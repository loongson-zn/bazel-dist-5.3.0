#!/bin/bash
#
# Copyright 2015 The Bazel Authors. All rights reserved.
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#    http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.

set -eu

# Load the test setup defined in the parent directory
CURRENT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
source "${CURRENT_DIR}/../integration_test_setup.sh" \
  || { echo "integration_test_setup.sh not found!" >&2; exit 1; }


JAVA_TOOLS_ZIP="$1"; shift
if [[ "${JAVA_TOOLS_ZIP}" != "released" ]]; then
    if [[ "${JAVA_TOOLS_ZIP}" == file* ]]; then
        JAVA_TOOLS_ZIP_FILE_URL="${JAVA_TOOLS_ZIP}"
    else
        JAVA_TOOLS_ZIP_FILE_URL="file://$(rlocation io_bazel/$JAVA_TOOLS_ZIP)"
    fi
fi
JAVA_TOOLS_ZIP_FILE_URL=${JAVA_TOOLS_ZIP_FILE_URL:-}

JAVA_TOOLS_PREBUILT_ZIP="$1"; shift
if [[ "${JAVA_TOOLS_PREBUILT_ZIP}" != "released" ]]; then
    if [[ "${JAVA_TOOLS_PREBUILT_ZIP}" == file* ]]; then
        JAVA_TOOLS_PREBUILT_ZIP_FILE_URL="${JAVA_TOOLS_PREBUILT_ZIP}"
    else
        JAVA_TOOLS_PREBUILT_ZIP_FILE_URL="file://$(rlocation io_bazel/$JAVA_TOOLS_PREBUILT_ZIP)"
    fi
    # Remove the repo overrides that are set up some for Bazel CI workers.
    inplace-sed "/override_repository=remote_java_tools=/d" "$TEST_TMPDIR/bazelrc"
    inplace-sed "/override_repository=remote_java_tools_linux=/d" "$TEST_TMPDIR/bazelrc"
    inplace-sed "/override_repository=remote_java_tools_windows=/d" "$TEST_TMPDIR/bazelrc"
    inplace-sed "/override_repository=remote_java_tools_darwin=/d" "$TEST_TMPDIR/bazelrc"
fi
JAVA_TOOLS_PREBUILT_ZIP_FILE_URL=${JAVA_TOOLS_PREBUILT_ZIP_FILE_URL:-}

COVERAGE_GENERATOR_DIR="$1"; shift
if [[ "${COVERAGE_GENERATOR_DIR}" != "released" ]]; then
  COVERAGE_GENERATOR_DIR="$(rlocation io_bazel/$COVERAGE_GENERATOR_DIR)"
  add_to_bazelrc "build --override_repository=remote_coverage_tools=${COVERAGE_GENERATOR_DIR}"
fi

if [[ $# -gt 0 ]]; then
    JAVA_RUNTIME_VERSION="$1"; shift
    add_to_bazelrc "build --java_runtime_version=${JAVA_RUNTIME_VERSION}"
    add_to_bazelrc "build --tool_java_runtime_version=${JAVA_RUNTIME_VERSION}"
fi

function set_up() {
    cat >>WORKSPACE <<EOF
load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")
# java_tools versions only used to test Bazel with various JDK toolchains.
EOF

    if [[ ! -z "${JAVA_TOOLS_ZIP_FILE_URL}" ]]; then
    cat >>WORKSPACE <<EOF
http_archive(
    name = "remote_java_tools",
    urls = ["${JAVA_TOOLS_ZIP_FILE_URL}"]
)
http_archive(
    name = "remote_java_tools_linux",
    urls = ["${JAVA_TOOLS_PREBUILT_ZIP_FILE_URL}"]
)
http_archive(
    name = "remote_java_tools_windows",
    urls = ["${JAVA_TOOLS_PREBUILT_ZIP_FILE_URL}"]
)
http_archive(
    name = "remote_java_tools_darwin",
    urls = ["${JAVA_TOOLS_PREBUILT_ZIP_FILE_URL}"]
)
EOF
    fi

    cat $(rlocation io_bazel/src/test/shell/bazel/testdata/jdk_http_archives) >> WORKSPACE
}

# Returns 0 if gcov is not installed or if a version before 7.0 was found.
# Returns 1 otherwise.
function is_gcov_missing_or_wrong_version() {
  local -r gcov_location=$(which gcov)
  if [[ ! -x ${gcov_location:-/usr/bin/gcov} ]]; then
    echo "gcov not installed."
    return 0
  fi

  "$gcov_location" -version | grep "LLVM" && \
      echo "gcov LLVM version not supported." && return 0
  # gcov -v | grep "gcov" outputs a line that looks like this:
  # gcov (Debian 7.3.0-5) 7.3.0
  local gcov_version="$(gcov -v | grep "gcov" | cut -d " " -f 4 | cut -d "." -f 1)"
  [ "$gcov_version" -lt 7 ] \
      && echo "gcov versions before 7.0 is not supported." && return 0
  return 1
}

# Asserts if the given expected coverage result is included in the given output
# file.
#
# - expected_coverage The expected result that must be included in the output.
# - output_file       The location of the coverage output file.
function assert_coverage_result() {
    local expected_coverage="${1}"; shift
    local output_file="${1}"; shift

    # Replace newlines with commas to facilitate the assertion.
    local expected_coverage_no_newlines="$( echo "$expected_coverage" | tr '\n' ',' )"
    local output_file_no_newlines="$( cat "$output_file" | tr '\n' ',' )"

    (echo "$output_file_no_newlines" \
        | grep -F "$expected_coverage_no_newlines") \
        || fail "Expected coverage result
<$expected_coverage>
was not found in actual coverage report:
<$( cat "$output_file" )>"
}

# Returns the path of the code coverage report that was generated by Bazel by
# looking at the current $TEST_log. The method fails if TEST_log does not
# contain any coverage report for a passed test.
function get_coverage_file_path_from_test_log() {
  local ending_part="$(sed -n -e '/PASSED/,$p' "$TEST_log")"

  local coverage_file_path=$(grep -Eo "/[/a-zA-Z0-9\.\_\-]+\.dat$" <<< "$ending_part")
  [[ -e "$coverage_file_path" ]] || fail "Coverage output file does not exist!"
  echo "$coverage_file_path"
}

function test_java_test_coverage() {
  cat <<EOF > BUILD
load("@bazel_tools//tools/jdk:default_java_toolchain.bzl", "default_java_toolchain")

java_test(
    name = "test",
    srcs = glob(["src/test/**/*.java"]),
    test_class = "com.example.TestCollatz",
    deps = [":collatz-lib"],
)

java_library(
    name = "collatz-lib",
    srcs = glob(["src/main/**/*.java"]),
)

default_java_toolchain(
    name = "custom_toolchain"
)
EOF

  mkdir -p src/main/com/example
  cat <<EOF > src/main/com/example/Collatz.java
package com.example;

public class Collatz {

  public static int getCollatzFinal(int n) {
    if (n == 1) {
      return 1;
    }
    if (n % 2 == 0) {
      return getCollatzFinal(n / 2);
    } else {
      return getCollatzFinal(n * 3 + 1);
    }
  }

}
EOF

  mkdir -p src/test/com/example
  cat <<EOF > src/test/com/example/TestCollatz.java
package com.example;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestCollatz {

  @Test
  public void testGetCollatzFinal() {
    assertEquals(Collatz.getCollatzFinal(1), 1);
    assertEquals(Collatz.getCollatzFinal(5), 1);
    assertEquals(Collatz.getCollatzFinal(10), 1);
    assertEquals(Collatz.getCollatzFinal(21), 1);
  }

}
EOF

  bazel coverage --test_output=all //:test &>$TEST_log || fail "Coverage for //:test failed"
  cat $TEST_log
  local coverage_file_path="$( get_coverage_file_path_from_test_log )"

  local expected_result="SF:src/main/com/example/Collatz.java
FN:3,com/example/Collatz::<init> ()V
FN:6,com/example/Collatz::getCollatzFinal (I)I
FNDA:0,com/example/Collatz::<init> ()V
FNDA:1,com/example/Collatz::getCollatzFinal (I)I
FNF:2
FNH:1
BRDA:6,0,0,1
BRDA:6,0,1,1
BRDA:9,0,0,1
BRDA:9,0,1,1
BRF:4
BRH:4
DA:3,0
DA:6,1
DA:7,1
DA:9,1
DA:10,1
DA:12,1
LH:5
LF:6
end_of_record"

  assert_coverage_result "$expected_result" "$coverage_file_path"

  bazel coverage --test_output=all --java_toolchain=//:custom_toolchain //:test &>$TEST_log || fail "Coverage with default_java_toolchain for //:test failed"
  assert_coverage_result "$expected_result" "$coverage_file_path"
}

function test_java_test_coverage_combined_report() {

  cat <<EOF > BUILD
java_test(
    name = "test",
    srcs = glob(["src/test/**/*.java"]),
    test_class = "com.example.TestCollatz",
    deps = [":collatz-lib"],
)

java_library(
    name = "collatz-lib",
    srcs = glob(["src/main/**/*.java"]),
)
EOF

  mkdir -p src/main/com/example
  cat <<EOF > src/main/com/example/Collatz.java
package com.example;

public class Collatz {

  public static int getCollatzFinal(int n) {
    if (n == 1) {
      return 1;
    }
    if (n % 2 == 0) {
      return getCollatzFinal(n / 2);
    } else {
      return getCollatzFinal(n * 3 + 1);
    }
  }

}
EOF

  mkdir -p src/test/com/example
  cat <<EOF > src/test/com/example/TestCollatz.java
package com.example;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestCollatz {

  @Test
  public void testGetCollatzFinal() {
    assertEquals(Collatz.getCollatzFinal(1), 1);
    assertEquals(Collatz.getCollatzFinal(5), 1);
    assertEquals(Collatz.getCollatzFinal(10), 1);
    assertEquals(Collatz.getCollatzFinal(21), 1);
  }

}
EOF

  bazel coverage --test_output=all //:test --coverage_report_generator=@bazel_tools//tools/test:coverage_report_generator --combined_report=lcov &>$TEST_log \
   || echo "Coverage for //:test failed"

  local expected_result="SF:src/main/com/example/Collatz.java
FN:3,com/example/Collatz::<init> ()V
FN:6,com/example/Collatz::getCollatzFinal (I)I
FNDA:0,com/example/Collatz::<init> ()V
FNDA:1,com/example/Collatz::getCollatzFinal (I)I
FNF:2
FNH:1
BRDA:6,0,0,1
BRDA:6,0,1,1
BRDA:9,0,0,1
BRDA:9,0,1,1
BRF:4
BRH:4
DA:3,0
DA:6,1
DA:7,1
DA:9,1
DA:10,1
DA:12,1
LH:5
LF:6
end_of_record"

  assert_coverage_result "$expected_result" "./bazel-out/_coverage/_coverage_report.dat"
}

function test_java_test_java_import_coverage() {

  cat <<EOF > BUILD
java_test(
    name = "test",
    srcs = glob(["src/test/**/*.java"]),
    test_class = "com.example.TestCollatz",
    deps = [":collatz-import"],
)

java_import(
    name = "collatz-import",
    jars = [":libcollatz-lib.jar"],
)

java_library(
    name = "collatz-lib",
    srcs = glob(["src/main/**/*.java"]),
)
EOF

  mkdir -p src/main/com/example
  cat <<EOF > src/main/com/example/Collatz.java
package com.example;

public class Collatz {

  public static int getCollatzFinal(int n) {
    if (n == 1) {
      return 1;
    }
    if (n % 2 == 0) {
      return getCollatzFinal(n / 2);
    } else {
      return getCollatzFinal(n * 3 + 1);
    }
  }

}
EOF

  mkdir -p src/test/com/example
  cat <<EOF > src/test/com/example/TestCollatz.java
package com.example;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestCollatz {

  @Test
  public void testGetCollatzFinal() {
    assertEquals(Collatz.getCollatzFinal(1), 1);
    assertEquals(Collatz.getCollatzFinal(5), 1);
    assertEquals(Collatz.getCollatzFinal(10), 1);
    assertEquals(Collatz.getCollatzFinal(21), 1);
  }

}
EOF

  bazel coverage --test_output=all //:test &>$TEST_log || fail "Coverage for //:test failed"
  local coverage_file_path="$( get_coverage_file_path_from_test_log )"

  local expected_result="SF:src/main/com/example/Collatz.java
FN:3,com/example/Collatz::<init> ()V
FN:6,com/example/Collatz::getCollatzFinal (I)I
FNDA:0,com/example/Collatz::<init> ()V
FNDA:1,com/example/Collatz::getCollatzFinal (I)I
FNF:2
FNH:1
BRDA:6,0,0,1
BRDA:6,0,1,1
BRDA:9,0,0,1
BRDA:9,0,1,1
BRF:4
BRH:4
DA:3,0
DA:6,1
DA:7,1
DA:9,1
DA:10,1
DA:12,1
LH:5
LF:6
end_of_record"

  assert_coverage_result "$expected_result" "$coverage_file_path"
}

function test_run_jar_in_subprocess_empty_env() {
  mkdir -p java/cov
  mkdir -p javatests/cov
  cat >java/cov/BUILD <<EOF
package(default_visibility=['//visibility:public'])
java_binary(name = 'Cov',
            main_class = 'cov.Cov',
            srcs = ['Cov.java'])
EOF

  cat >java/cov/Cov.java <<EOF
package cov;
public class Cov {
  public static void main(String[] args) {
    if (args.length == 1) {
      if (Boolean.parseBoolean(args[0])) {
        System.out.println("Boolean.parseBoolean returned true");  // line 6
      } else {
        System.out.println("Boolean.parseBoolean returned false"); // line 8
      }
    }
  }
}
EOF

  cat >javatests/cov/BUILD <<EOF
java_test(name = 'CovTest',
          srcs = ['CovTest.java'],
          data = ['//java/cov:Cov_deploy.jar'],
          test_class = 'cov.CovTest')
EOF

  cat >javatests/cov/CovTest.java <<EOF
package cov;
import junit.framework.TestCase;
import java.io.*;
import java.nio.channels.*;
import java.net.InetAddress;
public class CovTest extends TestCase {
  private static Process startSubprocess(String arg) throws Exception {
   String path = System.getenv("TEST_SRCDIR") + "/main/java/cov/Cov_deploy.jar";
    String[] command = {
      // Run the deploy jar by invoking JVM because the integration tests
      // cannot use the java launcher (b/29388516).
      System.getProperty("java.home") + "/bin/java", "-jar", path, arg
    };
    ProcessBuilder pb = new ProcessBuilder(command);
    pb.environment().clear();
    return pb.start();
  }
  public void testTrivial() throws Exception {
    Process subprocessTrue = startSubprocess("true");
    Process subprocessFalse = startSubprocess("false");
    subprocessTrue.waitFor();
    subprocessFalse.waitFor();
    String line;
    BufferedReader input = new BufferedReader(new InputStreamReader(subprocessTrue.getInputStream()));
    while ((line = input.readLine()) != null) {
      System.out.println(line);
     }
    input.close();
    BufferedReader err = new BufferedReader(new InputStreamReader(subprocessTrue.getErrorStream()));
    while ((line = err.readLine()) != null) {
      System.out.println(line);
     }
    err.close();

    input = new BufferedReader(new InputStreamReader(subprocessFalse.getInputStream()));
    while ((line = input.readLine()) != null) {
      System.out.println(line);
     }
    input.close();
    err = new BufferedReader(new InputStreamReader(subprocessFalse.getErrorStream()));
    while ((line = err.readLine()) != null) {
      System.out.println(line);
     }
    err.close();
  }
}
EOF

  # Only assess that the coverage run was successful.
  # --nooutputredirect is needed for blaze to print the output of the jar
  bazel coverage --test_output=all --test_arg=--nooutputredirect \
    javatests/cov:CovTest >"${TEST_log}" || fail "Expected success"
  expect_not_log "JACOCO_METADATA_JAR/JACOCO_MAIN_CLASS environment variables not set"
  expect_log "Boolean.parseBoolean returned true"
  expect_log "Boolean.parseBoolean returned false"
}

function test_runtime_deploy_jar() {
  mkdir -p java/cov
  mkdir -p javatests/cov
  cat >java/cov/BUILD <<EOF
package(default_visibility=['//visibility:public'])
java_binary(
    name = 'RandomBinary',
    main_class = 'cov.RandomBinary',
    srcs = ['RandomBinary.java'],
)

java_library(
    name = 'Cov',
    srcs = ['Cov.java']
)
EOF

  cat >java/cov/RandomBinary.java <<EOF
package cov;
public class RandomBinary {
  public static void main(String[] args) throws Exception {
    throw new Exception("RandomBinary should not be run!");
  }
}
EOF

  cat >java/cov/Cov.java <<EOF
package cov;
public class Cov {
  public static void main(String[] args) {
    if (args.length == 1) {
      if (Boolean.parseBoolean(args[0])) {
        System.out.println("Boolean.parseBoolean returned true");  // line 6
      } else {
        System.out.println("Boolean.parseBoolean returned false"); // line 8
      }
    }
  }
}
EOF

  cat >javatests/cov/BUILD <<EOF
java_test(name = 'CovTest',
          srcs = ['CovTest.java'],
          deps = ['//java/cov:Cov'],
          runtime_deps = ['//java/cov:RandomBinary_deploy.jar'],
          test_class = 'cov.CovTest')
EOF

  cat >javatests/cov/CovTest.java <<EOF
package cov;
import junit.framework.TestCase;
import java.io.*;
import java.nio.channels.*;
import java.net.InetAddress;
public class CovTest extends TestCase {
  public void testTrivial() throws Exception {
    Cov.main(new String[] {"true"});
    Cov.main(new String[] {"false"});
  }
}
EOF

  bazel coverage --test_output=all --instrumentation_filter=//java/cov \
      javatests/cov:CovTest >"${TEST_log}"
  local coverage_file_path="$( get_coverage_file_path_from_test_log )"
  assert_coverage_result "java/cov/Cov.java" ${coverage_file_path}
}

function test_runtime_and_data_deploy_jars() {
  mkdir -p java/cov
  mkdir -p javatests/cov
  cat >java/cov/BUILD <<EOF
package(default_visibility=['//visibility:public'])
java_binary(
    name = 'RandomBinary',
    main_class = 'cov.RandomBinary',
    srcs = ['RandomBinary.java'],
)

java_binary(
    name = 'Cov',
    srcs = ['Cov.java'],
    main_class = 'cov.Cov'
)
EOF

  cat >java/cov/RandomBinary.java <<EOF
package cov;
public class RandomBinary {
  public static void main(String[] args) throws Exception {
    throw new Exception("RandomBinary should not be run!");
  }
}
EOF

  cat >java/cov/Cov.java <<EOF
package cov;
public class Cov {
  public static void main(String[] args) {
    if (args.length == 1) {
      if (Boolean.parseBoolean(args[0])) {
        System.out.println("Boolean.parseBoolean returned true");  // line 6
      } else {
        System.out.println("Boolean.parseBoolean returned false"); // line 8
      }
    }
  }
}
EOF

  cat >javatests/cov/BUILD <<EOF
java_test(name = 'CovTest',
          srcs = ['CovTest.java'],
          data = ['//java/cov:Cov_deploy.jar'],
          runtime_deps = ['//java/cov:RandomBinary_deploy.jar'],
          test_class = 'cov.CovTest')
EOF

  cat >javatests/cov/CovTest.java <<EOF
package cov;
import junit.framework.TestCase;
import java.io.*;
import java.nio.channels.*;
import java.net.InetAddress;
public class CovTest extends TestCase {
  private static Process startSubprocess(String arg) throws Exception {
   String path = System.getenv("TEST_SRCDIR") + "/main/java/cov/Cov_deploy.jar";
    String[] command = {
      // Run the deploy jar by invoking JVM because the integration tests
      // cannot use the java launcher (b/29388516).
      System.getProperty("java.home") + "/bin/java", "-jar", path, arg
    };
    return new ProcessBuilder(command).start();
  }
  public void testTrivial() throws Exception {
    Process subprocessTrue = startSubprocess("true");
    Process subprocessFalse = startSubprocess("false");
    subprocessTrue.waitFor();
    subprocessFalse.waitFor();
    String line;
    BufferedReader input = new BufferedReader(new InputStreamReader(subprocessTrue.getInputStream()));
    while ((line = input.readLine()) != null) {
      System.out.println(line);
     }
    input.close();
    BufferedReader err = new BufferedReader(new InputStreamReader(subprocessTrue.getErrorStream()));
    while ((line = err.readLine()) != null) {
      System.out.println(line);
     }
    err.close();

    input = new BufferedReader(new InputStreamReader(subprocessFalse.getInputStream()));
    while ((line = input.readLine()) != null) {
      System.out.println(line);
     }
    input.close();
    err = new BufferedReader(new InputStreamReader(subprocessFalse.getErrorStream()));
    while ((line = err.readLine()) != null) {
      System.out.println(line);
     }
    err.close();
  }
}
EOF

  # --nooutputredirect is needed for blaze to print the output of the deploy jar
  bazel coverage --test_output=all --test_arg=--nooutputredirect \
      --instrumentation_filter=//java/cov javatests/cov:CovTest >"${TEST_log}"
  local coverage_file_path="$( get_coverage_file_path_from_test_log )"

  local expected_result_cov="SF:java/cov/Cov.java
FN:2,cov/Cov::<init> ()V
FN:4,cov/Cov::main ([Ljava/lang/String;)V
FNDA:0,cov/Cov::<init> ()V
FNDA:2,cov/Cov::main ([Ljava/lang/String;)V
FNF:2
FNH:1
BRDA:4,0,0,0
BRDA:4,0,1,2
BRDA:5,0,0,1
BRDA:5,0,1,1
BRF:4
BRH:3
DA:2,0
DA:4,2
DA:5,2
DA:6,1
DA:8,1
DA:11,2
LH:5
LF:6
end_of_record"

  local expected_result_random="SF:java/cov/RandomBinary.java
FN:2,cov/RandomBinary::<init> ()V
FN:4,cov/RandomBinary::main ([Ljava/lang/String;)V
FNDA:0,cov/RandomBinary::<init> ()V
FNDA:0,cov/RandomBinary::main ([Ljava/lang/String;)V
FNF:2
FNH:0
DA:2,0
DA:4,0
LH:0
LF:2
end_of_record"

  # we do not assert the order of the source files in the coverage report
  # only that they are both included and correctly merged
  assert_coverage_result "$expected_result_cov" ${coverage_file_path}
  assert_coverage_result "$expected_result_random" ${coverage_file_path}
}

function test_java_string_switch_coverage() {
  # Verify that Jacoco's filtering is being applied.
  # Switches on strings generate over double the number of expected branches
  # (because a switch on String::hashCode is made first) - these branches should
  # be filtered.
  cat <<EOF > BUILD
java_test(
    name = "test",
    srcs = glob(["src/test/**/*.java"]),
    test_class = "com.example.TestSwitch",
    deps = [":switch-lib"],
)

java_library(
    name = "switch-lib",
    srcs = glob(["src/main/**/*.java"]),
)
EOF

  mkdir -p src/main/com/example
  cat <<EOF > src/main/com/example/Switch.java
package com.example;

public class Switch {

  public static int switchString(String input) {
    switch (input) {
      case "AA":
        return 0;
      case "BB":
        return 1;
      case "CC":
        return 2;
      default:
        return -1;
    }
  }
}
EOF

  mkdir -p src/test/com/example
  cat <<EOF > src/test/com/example/TestSwitch.java
package com.example;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestSwitch {

  @Test
  public void testValues() {
    assertEquals(Switch.switchString("CC"), 2);
    // "Aa" has a hash collision with "BB"
    assertEquals(Switch.switchString("Aa"), -1);
    assertEquals(Switch.switchString("DD"), -1);
  }

}
EOF

  bazel coverage --test_output=all //:test --coverage_report_generator=@bazel_tools//tools/test:coverage_report_generator --combined_report=lcov &>$TEST_log \
   || echo "Coverage for //:test failed"

  local coverage_file_path="$( get_coverage_file_path_from_test_log )"

  local expected_result="SF:src/main/com/example/Switch.java
FN:3,com/example/Switch::<init> ()V
FN:6,com/example/Switch::switchString (Ljava/lang/String;)I
FNDA:0,com/example/Switch::<init> ()V
FNDA:1,com/example/Switch::switchString (Ljava/lang/String;)I
FNF:2
FNH:1
BRDA:6,0,0,0
BRDA:6,0,1,0
BRDA:6,0,2,1
BRDA:6,0,3,1
BRF:4
BRH:2
DA:3,0
DA:6,1
DA:8,0
DA:10,0
DA:12,1
DA:14,1
LH:3
LF:6
end_of_record"

  assert_coverage_result "$expected_result" "$coverage_file_path"
}


function test_finally_block_branch_coverage() {
  # Verify branches in finally blocks are handled correctly.
  # The java compiler duplicates finally blocks for the various code paths that
  # may enter them (e.g. via an exception handler or when no exception is
  # thrown).
  cat <<EOF > BUILD
java_test(
    name = "test",
    srcs = glob(["src/test/**/*.java"]),
    test_class = "com.example.TestFinally",
    deps = [":finally-lib"],
)

java_library(
    name = "finally-lib",
    srcs = glob(["src/main/**/*.java"]),
)
EOF

  mkdir -p src/main/com/example
  cat <<EOF > src/main/com/example/Finally.java
package com.example;

public class Finally {

  private static int secret = 0;

  public static int runFinally(int x) {
    try {
      if (x == 1 || x == -1) {
        throw new RuntimeException();
      }
      if (x % 2 == 0) {
        return x * 2;
      } else {
        return x * 2 - 1;
      }
    } finally {
      if (x >= 0) {
        secret++;
      } else {
        secret--;
      }
    }
  }
}
EOF

  mkdir -p src/test/com/example
  cat <<EOF > src/test/com/example/TestFinally.java
package com.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import org.junit.Test;

public class TestFinally {

  @Test
  public void testEven() {
    assertEquals(4, Finally.runFinally(2));
  }
  @Test
  public void testOdd() {
    assertEquals(5, Finally.runFinally(3));
  }
  @Test
  public void testNegativeEven() {
    assertEquals(-4, Finally.runFinally(-2));
  }
  @Test
  public void testNegativeOdd() {
    assertEquals(-7, Finally.runFinally(-3));
  }
  @Test
  public void testException() {
    assertThrows(RuntimeException.class, () -> Finally.runFinally(1));
  }
  @Test
  public void testNegativeException() {
    assertThrows(RuntimeException.class, () -> Finally.runFinally(-1));
  }

}
EOF

  # For the sake of brevity, only check the output for the branches
  # corresponding to the finally block in the method under test rather than the
  # entire coverage output.
  bazel coverage --test_output=all //:test \
    --coverage_report_generator=@bazel_tools//tools/test:coverage_report_generator \
    --combined_report=lcov &>$TEST_log \
    --test_filter=TestFinally.testNegativeException \
   || echo "Coverage for //:test failed"

    #--test_filter=".*(testNegativeException)" \
  local coverage_file_path="$( get_coverage_file_path_from_test_log )"
  local expected_result="BRDA:9,0,0,0
BRDA:9,0,1,1
BRDA:9,0,2,1
BRDA:9,0,3,0
BRDA:12,0,0,-
BRDA:12,0,1,-
BRDA:18,0,0,0
BRDA:18,0,1,1
BRF:8
BRH:3"
  assert_coverage_result "$expected_result" "$coverage_file_path"

  bazel coverage --test_output=all //:test \
    --coverage_report_generator=@bazel_tools//tools/test:coverage_report_generator \
    --combined_report=lcov &>$TEST_log \
    --test_filter=".*(testOdd|testNegativeOdd)" \
   || echo "Coverage for //:test failed"

  local coverage_file_path="$( get_coverage_file_path_from_test_log )"
  local expected_result="BRDA:9,0,0,0
BRDA:9,0,1,1
BRDA:9,0,2,0
BRDA:9,0,3,1
BRDA:12,0,0,1
BRDA:12,0,1,0
BRDA:18,0,0,1
BRDA:18,0,1,1
BRF:8
BRH:5"
  assert_coverage_result "$expected_result" "$coverage_file_path"

  bazel coverage --test_output=all //:test \
    --coverage_report_generator=@bazel_tools//tools/test:coverage_report_generator \
    --combined_report=lcov &>$TEST_log \
    --test_filter=".*(testEven|testNegativeOdd)" \
   || echo "Coverage for //:test failed"

  local coverage_file_path="$( get_coverage_file_path_from_test_log )"
  local expected_result="BRDA:9,0,0,0
BRDA:9,0,1,1
BRDA:9,0,2,0
BRDA:9,0,3,1
BRDA:12,0,0,1
BRDA:12,0,1,1
BRDA:18,0,0,1
BRDA:18,0,1,1
BRF:8
BRH:6"
  assert_coverage_result "$expected_result" "$coverage_file_path"

  bazel coverage --test_output=all //:test \
    --coverage_report_generator=@bazel_tools//tools/test:coverage_report_generator \
    --combined_report=lcov &>$TEST_log \
    --test_filter=".*(testNegativeEven|testException)" \
   || echo "Coverage for //:test failed"

  local coverage_file_path="$( get_coverage_file_path_from_test_log )"
  local expected_result="BRDA:9,0,0,1
BRDA:9,0,1,1
BRDA:9,0,2,0
BRDA:9,0,3,1
BRDA:12,0,0,0
BRDA:12,0,1,1
BRDA:18,0,0,1
BRDA:18,0,1,1
BRF:8
BRH:6"
  assert_coverage_result "$expected_result" "$coverage_file_path"

  bazel coverage --test_output=all //:test \
    --coverage_report_generator=@bazel_tools//tools/test:coverage_report_generator \
    --combined_report=lcov &>$TEST_log \
    --test_filter=".*(testNegativeEven|testNegativeOdd)" \
   || echo "Coverage for //:test failed"

  local coverage_file_path="$( get_coverage_file_path_from_test_log )"
  local expected_result="BRDA:9,0,0,0
BRDA:9,0,1,1
BRDA:9,0,2,0
BRDA:9,0,3,1
BRDA:12,0,0,1
BRDA:12,0,1,1
BRDA:18,0,0,0
BRDA:18,0,1,1
BRF:8
BRH:5"
  assert_coverage_result "$expected_result" "$coverage_file_path"

  bazel coverage --test_output=all //:test \
    --coverage_report_generator=@bazel_tools//tools/test:coverage_report_generator \
    --combined_report=lcov &>$TEST_log \
    --test_filter=".*(testOdd|testException)" \
   || echo "Coverage for //:test failed"

  local coverage_file_path="$( get_coverage_file_path_from_test_log )"
  local expected_result="BRDA:9,0,0,1
BRDA:9,0,1,1
BRDA:9,0,2,0
BRDA:9,0,3,1
BRDA:12,0,0,1
BRDA:12,0,1,0
BRDA:18,0,0,1
BRDA:18,0,1,0
BRF:8
BRH:5"
  assert_coverage_result "$expected_result" "$coverage_file_path"
}

function test_java_test_coverage_cc_binary() {
  if is_gcov_missing_or_wrong_version; then
    echo "Skipping test." && return
  fi

  ########### Setup source files and BUILD file ###########
  cat <<EOF > BUILD
java_test(
    name = "NumJava",
    srcs = ["NumJava.java"],
    data = ["//examples/cpp:num-world"],
    main_class = "main.NumJava",
    use_testrunner = False,
)
EOF
  cat <<EOF > NumJava.java
package main;

public class NumJava {
  public static void main(String[] args) throws java.io.IOException {
    Runtime.getRuntime().exec("examples/cpp/num-world");
  }
}
EOF

  mkdir -p examples/cpp

  cat <<EOF > examples/cpp/BUILD
package(default_visibility = ["//visibility:public"])

cc_binary(
    name = "num-world",
    srcs = ["num-world.cc"],
    deps = [":num-lib"],
)

cc_library(
    name = "num-lib",
    srcs = ["num-lib.cc"],
    hdrs = ["num-lib.h"]
)
EOF

  cat <<EOF > examples/cpp/num-world.cc
#include "examples/cpp/num-lib.h"

using num::NumLib;

int main(int argc, char** argv) {
  NumLib lib(30);
  int value = 42;
  if (argc > 1) {
    value = 43;
  }
  lib.add_number(value);
  return 0;
}
EOF

  cat <<EOF > examples/cpp/num-lib.h
#ifndef EXAMPLES_CPP_NUM_LIB_H_
#define EXAMPLES_CPP_NUM_LIB_H_

namespace num {

class NumLib {
 public:
  explicit NumLib(int number);

  int add_number(int value);

 private:
  int number_;
};

}  // namespace num

#endif  // EXAMPLES_CPP_NUM_LIB_H_
EOF

  cat <<EOF > examples/cpp/num-lib.cc
#include "examples/cpp/num-lib.h"

namespace num {

NumLib::NumLib(int number) : number_(number) {
}

int NumLib::add_number(int value) {
  return number_ + value;
}

}  // namespace num
EOF

  ########### Run bazel coverage ###########
  bazel coverage  --test_output=all \
      //:NumJava &>$TEST_log || fail "Coverage for //:NumJava failed"

  ########### Assert coverage results. ###########
  local coverage_file_path="$( get_coverage_file_path_from_test_log )"
  local expected_result_num_lib="SF:examples/cpp/num-lib.cc
FN:8,_ZN3num6NumLib10add_numberEi
FN:5,_ZN3num6NumLibC2Ei
FNDA:1,_ZN3num6NumLib10add_numberEi
FNDA:1,_ZN3num6NumLibC2Ei
FNF:2
FNH:2
DA:5,1
DA:6,1
DA:8,1
DA:9,1
LH:4
LF:4
end_of_record"
  assert_coverage_result "$expected_result_num_lib" "$coverage_file_path"
  local coverage_result_num_lib_header="SF:examples/cpp/num-world.cc
FN:5,main
FNDA:1,main
FNF:1
FNH:1
DA:5,1
DA:6,1
DA:7,1
DA:8,1
DA:9,0
DA:11,1
DA:12,1
LH:6
LF:7
end_of_record"
  assert_coverage_result "$coverage_result_num_lib_header" "$coverage_file_path"
}

run_suite "test tests"
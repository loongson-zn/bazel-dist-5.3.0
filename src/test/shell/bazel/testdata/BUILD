load("//:distdir_deps.bzl", "gen_workspace_stanza")

package(default_testonly = True)

filegroup(
    name = "srcs",
    testonly = False,
    srcs = glob(["**"]),
    visibility = ["//src/test/shell/bazel:__pkg__"],
)

filegroup(
    name = "git-repos",
    srcs = [
        "outer-planets-repo.tar.gz",
        "pluto-repo.tar.gz",
        "refetch-repo.tar.gz",
        "strip-prefix-repo.tar.gz",
    ],
    visibility = ["//src/test/shell/bazel:__pkg__"],
)

filegroup(
    name = "embedded_tools_deps_test_data",
    srcs = [
        "//src/test/shell/bazel/testdata:embedded_tools_srcs_deps",
    ],
    visibility = ["//src/test/shell/bazel:__pkg__"],
)

filegroup(
    name = "jdk_http_archives_filegroup",
    srcs = [
        "//src/test/shell/bazel/testdata:jdk_http_archives",
    ],
    visibility = ["//src/test/shell/bazel:__subpackages__"],
)

gen_workspace_stanza(
    name = "workspace_with_rules_java",
    out = "jdk_http_archives",
    repos = [
        "remote_java_tools_test",
        "remote_java_tools_test_linux",
        "remote_java_tools_test_windows",
        "remote_java_tools_test_darwin",
        "openjdk11_windows_arm64_archive",
        "openjdk17_windows_arm64_archive",
    ],
    template = "jdk_http_archives.tmpl",
    visibility = ["//:__pkg__"],
)

exports_files(["zstd_test_archive.tar.zst"])

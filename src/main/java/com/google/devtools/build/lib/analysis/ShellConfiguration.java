// Copyright 2018 The Bazel Authors. All rights reserved.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//    http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
package com.google.devtools.build.lib.analysis;

import com.google.common.collect.ImmutableMap;
import com.google.devtools.build.lib.analysis.config.BuildOptions;
import com.google.devtools.build.lib.analysis.config.Fragment;
import com.google.devtools.build.lib.analysis.config.FragmentOptions;
import com.google.devtools.build.lib.analysis.config.RequiresOptions;
import com.google.devtools.build.lib.util.OS;
import com.google.devtools.build.lib.util.OptionsUtils.PathFragmentConverter;
import com.google.devtools.build.lib.vfs.PathFragment;
import com.google.devtools.common.options.Option;
import com.google.devtools.common.options.OptionDocumentationCategory;
import com.google.devtools.common.options.OptionEffectTag;
import com.google.devtools.common.options.OptionMetadataTag;
import java.util.function.Function;

/** A configuration fragment that tells where the shell is. */
@RequiresOptions(options = {ShellConfiguration.Options.class})
public class ShellConfiguration extends Fragment {
  private static final ImmutableMap<OS, PathFragment> OS_SPECIFIC_SHELL =
      ImmutableMap.<OS, PathFragment>builder()
          .put(OS.WINDOWS, PathFragment.create("c:/tools/msys64/usr/bin/bash.exe"))
          .put(OS.FREEBSD, PathFragment.create("/usr/local/bin/bash"))
          .put(OS.OPENBSD, PathFragment.create("/usr/local/bin/bash"))
          .build();

  private static Function<BuildOptions, PathFragment> shellExecutableFinder;

  /**
   * Injects a function for finding the shell executable path, given the current configuration's
   * {@link BuildOptions} and whatever system-specific logic the provider wishes to use.
   */
  public static void injectShellExecutableFinder(Function<BuildOptions, PathFragment> finder) {
    // It'd be nice not to have to set a global static field. But there are so many disparate calls
    // to getShellExecutable() (in both the build's analysis phase and in the run command) that
    // feeding this through instance variables is unwieldy. Fortunately this info is a function of
    // the Blaze implementation and not something that might change between builds.
    shellExecutableFinder = finder;
  }

  private final PathFragment shellExecutable;
  private final boolean useShBinaryStubScript;

  public ShellConfiguration(BuildOptions buildOptions) {
    this.shellExecutable = shellExecutableFinder.apply(buildOptions);
    this.useShBinaryStubScript = buildOptions.get(Options.class).useShBinaryStubScript;
  }

  public PathFragment getShellExecutable() {
    return shellExecutable;
  }

  public boolean useShBinaryStubScript() {
    return useShBinaryStubScript;
  }

  /** An option that tells Bazel where the shell is. */
  public static class Options extends FragmentOptions {
    @Option(
        name = "shell_executable",
        converter = PathFragmentConverter.class,
        defaultValue = "null",
        documentationCategory = OptionDocumentationCategory.UNCATEGORIZED,
        effectTags = {OptionEffectTag.LOADING_AND_ANALYSIS},
        help =
            "Absolute path to the shell executable for Bazel to use. If this is unset, but the "
                + "BAZEL_SH environment variable is set on the first Bazel invocation (that starts "
                + "up a Bazel server), Bazel uses that. If neither is set, Bazel uses a hard-coded "
                + "default path depending on the operating system it runs on (Windows: "
                + "c:/tools/msys64/usr/bin/bash.exe, FreeBSD: /usr/local/bin/bash, all others: "
                + "/bin/bash). Note that using a shell that is not compatible with bash may lead "
                + "to build failures or runtime failures of the generated binaries."
    )
    public PathFragment shellExecutable;

    @Option(
        name = "experimental_use_sh_binary_stub_script",
        documentationCategory = OptionDocumentationCategory.UNDOCUMENTED,
        effectTags = {OptionEffectTag.AFFECTS_OUTPUTS},
        metadataTags = {OptionMetadataTag.EXPERIMENTAL},
        defaultValue = "false",
        help = "If enabled, use a stub script for sh_binary targets.")
    public boolean useShBinaryStubScript;

    @Override
    public Options getHost() {
      Options host = (Options) getDefault();
      host.shellExecutable = shellExecutable;
      host.useShBinaryStubScript = useShBinaryStubScript;
      return host;
    }
  }

  public static PathFragment determineShellExecutable(
      OS os, Options options, PathFragment defaultShell) {
    if (options.shellExecutable != null) {
      return options.shellExecutable;
    }

    // Honor BAZEL_SH env variable for backwards compatibility.
    String path = System.getenv("BAZEL_SH");
    if (path != null) {
      return PathFragment.create(path);
    }
    // TODO(ulfjack): instead of using the OS Bazel runs on, we need to use the exec platform,
    // which may be different for remote execution. For now, this can be overridden with
    // --shell_executable, so at least there's a workaround.
    PathFragment result = OS_SPECIFIC_SHELL.get(os);
    return result != null ? result : defaultShell;
  }
}
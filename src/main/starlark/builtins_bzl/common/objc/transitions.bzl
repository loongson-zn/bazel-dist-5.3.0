# Copyright 2020 The Bazel Authors. All rights reserved.
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

"""Definition of incoming apple crosstool transition."""

transition = _builtins.toplevel.transition

def _cpu_string(platform_type, settings):
    arch = _determine_single_architecture(platform_type, settings)
    if platform_type == MACOS:
        return "darwin_{}".format(arch)

    return "{}_{}".format(platform_type, arch)

def _determine_single_architecture(platform_type, settings):
    apple_split_cpu = settings["//command_line_option:apple_split_cpu"]
    if apple_split_cpu != None and len(apple_split_cpu) > 0:
        return apple_split_cpu
    if platform_type == IOS:
        ios_cpus = settings["//command_line_option:ios_multi_cpus"]
        if len(ios_cpus) > 0:
            return ios_cpus[0]
        cpu_value = settings["//command_line_option:cpu"]
        if cpu_value.startswith(IOS_CPU_PREFIX):
            return cpu_value[len(IOS_CPU_PREFIX):]
        if cpu_value == "darwin_arm64":
            return "sim_arm64"
        return DEFAULT_IOS_CPU
    if platform_type == WATCHOS:
        watchos_cpus = settings["//command_line_option:watchos_cpus"]
        if len(watchos_cpus) == 0:
            return DEFAULT_WATCHOS_CPU
        return watchos_cpus[0]
    if platform_type == TVOS:
        tvos_cpus = settings["//command_line_option:tvos_cpus"]
        if len(tvos_cpus) == 0:
            return DEFAULT_TVOS_CPU
        return tvos_cpus[0]
    if platform_type == MACOS:
        macos_cpus = settings["//command_line_option:macos_cpus"]
        if macos_cpus:
            return macos_cpus[0]
        cpu_value = settings["//command_line_option:cpu"]
        if cpu_value.startswith(DARWIN_CPU_PREFIX):
            return cpu_value[len(DARWIN_CPU_PREFIX):]
        return DEFAULT_MACOS_CPU
    if platform_type == CATALYST:
        catalyst_cpus = settings["//command_line_option:catalyst_cpus"]
        if len(catalyst_cpus) == 0:
            return DEFAULT_CATALYST_CPU
        return catalyst_cpus[0]

    fail("ERROR: Unhandled platform type {}".format(platform_type))

IOS = "ios"
WATCHOS = "watchos"
TVOS = "tvos"
MACOS = "macos"
CATALYST = "catalyst"
IOS_CPU_PREFIX = "ios_"
DARWIN_CPU_PREFIX = "darwin_"
DEFAULT_IOS_CPU = "x86_64"
DEFAULT_WATCHOS_CPU = "i386"
DEFAULT_TVOS_CPU = "x86_64"
DEFAULT_MACOS_CPU = "x86_64"
DEFAULT_CATALYST_CPU = "x86_64"

def _apple_crosstool_transition_impl(settings, attr):
    platform_type = str(settings["//command_line_option:apple_platform_type"])
    cpu = _cpu_string(platform_type, settings)
    if cpu == settings["//command_line_option:cpu"] and settings["//command_line_option:crosstool_top"] == settings["//command_line_option:apple_crosstool_top"]:
        return {}  # No changes necessary.
    return {
        "//command_line_option:apple configuration distinguisher": "applebin_" + platform_type,
        "//command_line_option:apple_platform_type": settings["//command_line_option:apple_platform_type"],
        "//command_line_option:apple_split_cpu": settings["//command_line_option:apple_split_cpu"],
        "//command_line_option:compiler": settings["//command_line_option:apple_compiler"],
        "//command_line_option:cpu": cpu,
        "//command_line_option:crosstool_top": (
            settings["//command_line_option:apple_crosstool_top"]
        ),
        "//command_line_option:platforms": [],
        "//command_line_option:fission": [],
        "//command_line_option:grte_top": settings["//command_line_option:apple_grte_top"],
        "//command_line_option:ios_minimum_os": settings["//command_line_option:ios_minimum_os"],
        "//command_line_option:macos_minimum_os": settings["//command_line_option:macos_minimum_os"],
        "//command_line_option:tvos_minimum_os": settings["//command_line_option:tvos_minimum_os"],
        "//command_line_option:watchos_minimum_os": settings["//command_line_option:watchos_minimum_os"],
    }

_apple_rule_base_transition_inputs = [
    "//command_line_option:apple configuration distinguisher",
    "//command_line_option:apple_compiler",
    "//command_line_option:compiler",
    "//command_line_option:apple_platform_type",
    "//command_line_option:apple_crosstool_top",
    "//command_line_option:crosstool_top",
    "//command_line_option:apple_split_cpu",
    "//command_line_option:apple_grte_top",
    "//command_line_option:cpu",
    "//command_line_option:ios_multi_cpus",
    "//command_line_option:macos_cpus",
    "//command_line_option:tvos_cpus",
    "//command_line_option:watchos_cpus",
    "//command_line_option:catalyst_cpus",
    "//command_line_option:ios_minimum_os",
    "//command_line_option:macos_minimum_os",
    "//command_line_option:tvos_minimum_os",
    "//command_line_option:watchos_minimum_os",
    "//command_line_option:platforms",
    "//command_line_option:fission",
    "//command_line_option:grte_top",
]
_apple_rule_base_transition_outputs = [
    "//command_line_option:apple configuration distinguisher",
    "//command_line_option:apple_platform_type",
    "//command_line_option:apple_split_cpu",
    "//command_line_option:compiler",
    "//command_line_option:cpu",
    "//command_line_option:crosstool_top",
    "//command_line_option:platforms",
    "//command_line_option:fission",
    "//command_line_option:grte_top",
    "//command_line_option:ios_minimum_os",
    "//command_line_option:macos_minimum_os",
    "//command_line_option:tvos_minimum_os",
    "//command_line_option:watchos_minimum_os",
]

apple_crosstool_transition = transition(
    implementation = _apple_crosstool_transition_impl,
    inputs = _apple_rule_base_transition_inputs,
    outputs = _apple_rule_base_transition_outputs,
)

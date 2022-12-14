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

package com.google.devtools.build.skydoc.fakebuildapi;

import com.google.devtools.build.lib.starlarkbuildapi.StarlarkConfigApi;
import com.google.devtools.build.skydoc.fakebuildapi.ConfigApiFakes.FakeBuildSettingDescriptor;
import com.google.devtools.build.skydoc.fakebuildapi.ConfigApiFakes.FakeExecTransitionFactory;
import net.starlark.java.eval.Printer;

/** Fake implementation of {@link StarlarkConfigApi}. */
public class FakeConfigApi implements StarlarkConfigApi {

  @Override
  public BuildSettingApi intSetting(Boolean flag) {
    return new FakeBuildSettingDescriptor();
  }

  @Override
  public BuildSettingApi boolSetting(Boolean flag) {
    return new FakeBuildSettingDescriptor();
  }

  @Override
  public BuildSettingApi stringSetting(Boolean flag, Boolean allowMultiple) {
    return new FakeBuildSettingDescriptor();
  }

  @Override
  public BuildSettingApi stringListSetting(Boolean flag, Boolean repeated) {
    return new FakeBuildSettingDescriptor();
  }

  @Override
  public ExecTransitionFactoryApi exec(Object execGroup) {
    return new FakeExecTransitionFactory();
  }

  @Override
  public void repr(Printer printer) {}
}

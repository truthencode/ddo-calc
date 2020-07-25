/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * Copyright 2015-2020 Andre White.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.truthencode.ddo.model.race

import org.scalatest.{FunSpec, Matchers}

/**
  * Created by adarr on 3/17/2017.
  */
class Race$Test extends FunSpec with Matchers {

  describe("Race$Test") {

    it("should determine Family") {
      val elf = Race.HalfElf
      val family = List(RaceFamily.Elven, RaceFamily.Human)
      elf.families should contain atLeastOneElementOf family
    }

  }
}

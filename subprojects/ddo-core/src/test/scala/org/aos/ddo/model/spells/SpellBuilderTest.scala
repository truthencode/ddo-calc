/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * Copyright 2015-2019 Andre White.
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
package org.aos.ddo.model.spells

import java.time.Duration

import org.aos.ddo.model.classes.CharacterClass
import org.aos.ddo.model.effect.{Effect, EffectList}
import org.aos.ddo.model.misc.CoolDown
import org.scalatest.{FunSpec, Matchers}
import org.scalatest.mockito.MockitoSugar

class SpellBuilderTest extends FunSpec with Matchers with MockitoSugar {
  private final val sampleDuration = 5L
  private final val sampleLevelCap = 32
  private val coolDown = mock[Option[Duration]]
  private val casterLevel = mock[CasterWithLevel]
  private val spellTarget =  mock[SpellTarget]
  private val casterLevelCap = mock[CasterLevelCap]
  private val effectList = mock[EffectList]
  private val spellInfo = mock[SpellInfo]
  describe("Spell Builder") {
    it("should support cool downs") {
      val builder = new SpellBuilder()
        .addSpellInfo(spellInfo)
        .addCasterClass(Seq(casterLevel))
        .addSpellTarget(List(spellTarget))
        .addSavingThrow(List.empty)
        .addSpellPoints(32)
        .addComponents(List.empty)
        .addLevelCap(casterLevelCap)
        .addEffect(effectList)
        //.build
    }
  }

}
/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * Copyright 2015-2021 Andre White.
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
package io.truthencode.ddo.model.effect.features

import io.truthencode.ddo.enhancement.BonusType
import io.truthencode.ddo.model.effect
import io.truthencode.ddo.model.effect.{
  DetailedEffect,
  Feature,
  ParameterModifier,
  PartModifier,
  SourceInfo,
  TriggerEvent
}
import io.truthencode.ddo.model.schools.School
import io.truthencode.ddo.model.spells.SpellPower
import io.truthencode.ddo.model.stats.BasicStat

/**
 * Affects your chance to do critical damage with specific spells
 */
trait SpellCriticalPercentFeature extends Features {
  self: SourceInfo =>
  protected val spellCriticalBonusType: BonusType

  private val src = this
  protected[this] val schoolCritical: Seq[(SpellPower, Int)]
  protected[this] val triggerOn: TriggerEvent
  protected[this] val triggerOff: TriggerEvent
  protected[this] val categories: Seq[effect.EffectCategories.Value]
  private[this] def spellCriticalPercentChance: Seq[Feature[_]] = {
    for {
      (s, a) <- schoolCritical
    } yield {
      new PartModifier[Int, BasicStat] with ParameterModifier[Int, BonusType] {

        lazy override protected[this] val partToModify: BasicStat =
          BasicStat.SpellCriticalChanceSchool(s)

        lazy override protected[this] val parameterToModify: BonusType =
          spellCriticalBonusType
        override val effectDetail: DetailedEffect = DetailedEffect(
          id = "SpellPoints",
          description = "Increases your critical spell chance",
          categories = categories.map(_.toString),
          triggersOn = triggerOn.entryName,
          triggersOff = triggerOff.entryName
        )
        override val source: SourceInfo = src
        override lazy val value: Int = a
        override lazy val effectText: Option[String] = Some(s"Spell Critical Percent Chance:$s by $value")
      }
    }
  }

  abstract override def features: Seq[Feature[_]] = {
    super.features ++ spellCriticalPercentChance
  }

}

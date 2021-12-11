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
import io.truthencode.ddo.model.effect.EffectCategories.EffectCategory
import io.truthencode.ddo.model.effect.{
  DetailedEffect,
  EffectCategories,
  Feature,
  ParameterModifier,
  PartModifier,
  SourceInfo,
  TriggerEvent
}
import io.truthencode.ddo.model.stats.BasicStat

/**
 * Damage added to your critical hits (Before Modifiers)
 */
trait CriticalDamageAmountFeature extends Features {
  self: SourceInfo =>
  protected val criticalDamageBonusType: BonusType
  protected val criticalDamageBonusAmount: Int
  private val src = this
  protected[this] val triggerOn: TriggerEvent
  protected[this] val triggerOff: TriggerEvent
  protected[this] val categories: Seq[EffectCategories.Value]
  private[this] val criticalDamageAmount =
    new PartModifier[Int, BasicStat] with ParameterModifier[Int, BonusType] {

      lazy override protected[this] val partToModify: BasicStat =
        BasicStat.ToHitChance

      lazy override protected[this] val parameterToModify: BonusType =
        criticalDamageBonusType

      lazy override val effectDetail: DetailedEffect = DetailedEffect(
        id = "ArmorClass",
        description = "Adds damage to critical hits",
        categories = categories.map(_.toString),
        triggersOn = triggerOn.entryName,
        triggersOff = triggerOff.entryName
      )
      override val source: SourceInfo = src
      override lazy val value: Int = criticalDamageBonusAmount
      override lazy val effectText: Option[String] = Some(s"Critical Damage: $value")
    }

  abstract override def features: Seq[Feature[_]] = {
    assert(criticalDamageAmount.value == criticalDamageBonusAmount)
    super.features :+ criticalDamageAmount
  }

}

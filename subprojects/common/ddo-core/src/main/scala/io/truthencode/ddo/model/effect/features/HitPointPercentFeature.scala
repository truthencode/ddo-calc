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
import io.truthencode.ddo.model.effect.{Feature, ParameterModifier, PartModifier, SourceInfo}
import io.truthencode.ddo.model.stats.BasicStat

/**
 * Affects your Hit Points by the specific Percent
 */
trait HitPointPercentFeature extends Features {
  self: SourceInfo =>
  protected val hitPointBonusType: BonusType
  protected val hitPointBonusPercent: Int
  private val src = this

  private[this] val hitPointPercent =
    new PartModifier[Int, BasicStat] with ParameterModifier[Int, BonusType] {

      lazy override protected[this] val partToModify: BasicStat =
        BasicStat.HitPoints

      lazy override protected[this] val parameterToModify: BonusType =
        hitPointBonusType

      override val source: SourceInfo = src
      override lazy val value: Int = hitPointBonusPercent
      override lazy val effectText: Option[String] = Some(s"Hit Points by $value%")
    }

  abstract override def features: Seq[Feature[_]] = {
    assert(hitPointPercent.value == hitPointBonusPercent)
    super.features :+ hitPointPercent
  }

}

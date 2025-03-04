/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * Copyright 2015-2025
 *
 * Author: Andre White.
 * FILE: ImprovedTurning.scala
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
package io.truthencode.ddo.model.feats

import io.truthencode.ddo.enhancement.BonusType
import io.truthencode.ddo.enhancement.BonusType.Feat
import io.truthencode.ddo.model.effect
import io.truthencode.ddo.model.effect.TriggerEvent.{Never, Passive}
import io.truthencode.ddo.model.effect.features.{
  Features,
  FeaturesImpl,
  TurnUndeadCasterLevelFeature
}
import io.truthencode.ddo.model.effect.{EffectCategories, Feature, SourceInfo, TriggerEvent}
import io.truthencode.ddo.support.requisite.{FeatRequisiteImpl, RequiresAllOfFeat}

trait ImprovedTurning extends FeatRequisiteImpl with Passive with Features {
  self: ClassFeat & RequiresAllOfFeat =>
  // prerequisite: Cleric, Paladin, Bane Of Undead[20]

  private val si = this
  private val undeadTurnsFeature = new FeaturesImpl
    with TurnUndeadCasterLevelFeature with SourceInfo {

    override val sourceId: String = si.sourceId
    override val sourceRef: AnyRef = si.sourceRef

    override protected lazy val triggerOn: Seq[TriggerEvent] = Seq(Passive)
    override protected lazy val triggerOff: Seq[TriggerEvent] = Seq(Never)

    override lazy val undeadCasterLevelBonusType: BonusType = Feat
    override val undeadCasterLevelBonusAmount: Int = 1
    override protected val undeadCasterLevelCategories: Seq[effect.EffectCategories.Value] =
      Seq(EffectCategories.TurnUndead)
  }
  override lazy val features: Seq[Feature[?]] = undeadTurnsFeature.features

}

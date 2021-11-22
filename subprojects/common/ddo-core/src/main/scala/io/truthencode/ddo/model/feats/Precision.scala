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
package io.truthencode.ddo.model.feats

import io.truthencode.ddo.model.attribute.Attribute
import io.truthencode.ddo.model.misc.DefaultCoolDown
import io.truthencode.ddo.support.requisite.{FeatRequisiteImpl, RequiresAttribute, RequiresBaB}

/**
 * Icon Feat Precision.png [[https://ddowiki.com/page/Precision Precision]] Active - Offensive Combat Stance While using
 * Precision mode, you gain +5% to hit and reduce the target's fortification against your attacks by 25%. Cannot be used
 * while raged. * Dexterity 13 Base Attack Bonus +1
 * @todo
 *   add Rage Prohibition
 */
protected[feats] trait Precision
  extends FeatRequisiteImpl with ActiveFeat with OffensiveCombatStance with RequiresAttribute with RequiresBaB
  with AlchemistBonusFeat with FighterBonusFeat with MartialArtsFeat with DefaultCoolDown {
  self: GeneralFeat =>
  override def requiresAttribute: Seq[(Attribute, Int)] =
    List((Attribute.Dexterity, 13))

  override def requiresBaB = 1
}

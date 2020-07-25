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
package io.truthencode.ddo.model.feats

import java.time.Duration

import io.truthencode.ddo.activation.AtWillEvent
import io.truthencode.ddo.model.attribute.Attribute.Strength
import io.truthencode.ddo.model.attribute.{Attribute, DexterityLinked, LinkedAttributeImpl, StrengthLinked}
import io.truthencode.ddo.model.effect.DifficultyCheck
import io.truthencode.ddo.support.ModifierStrategy
import io.truthencode.ddo.support.requisite.{FeatRequisiteImpl, FreeFeat}

/**
  * This feat has a chance to trip the target rendering it prone for a short time.
  * Strength or Dexterity save (whichever is higher) is used to oppose a DC of 10 + Strength modifier + related Enhancements + Vertigo.
  * Some creatures may be immune to this effect. Creatures larger or stronger than you are less likely to trip.
  * A successful Balance check negates this effect (DC of 10 + Strength modifier + related Enhancements + Vertigo).
  */
protected[feats] trait Trip
    extends FeatRequisiteImpl
    with ActiveFeat
    //   with DifficultyCheck
    with LinkedAttributeImpl
    with DexterityLinked
    with StrengthLinked
    with Tactical
    with FreeFeat {
  self: GeneralFeat =>
//  override def baseDC: Int = 10
//
//  override def statModifier: List[Attribute] = List(Strength)
//
//  override def modifierStrategy: ModifierStrategy = ModifierStrategy.HighestWins
  override def coolDown: Option[Duration] = Some(Duration.ofSeconds(15))
  // DC of 10 + Strength modifier + related Enhancements + Vertigo.

}
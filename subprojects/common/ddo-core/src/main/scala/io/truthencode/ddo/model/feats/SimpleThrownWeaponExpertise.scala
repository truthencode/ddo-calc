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

import io.truthencode.ddo.model.attribute.Attribute
import io.truthencode.ddo.model.classes.HeroicCharacterClass
import io.truthencode.ddo.model.classes.HeroicCharacterClass.Alchemist
import io.truthencode.ddo.support.requisite.{
  ClassRequisiteImpl,
  FeatRequisiteImpl,
  RequiresAllOfClass,
  RequiresAttribute
}

/**
  * You are skilled with the use of Simple Thrown Weapons (Throwing Daggers and Darts) and while using one, you gain Doubleshot equal to your Dexterity.
  *
  * @see [[https://ddowiki.com/page/Simple_Thrown_Weapon_Expertise]]
  */
protected[feats] trait SimpleThrownWeaponExpertise
    extends FeatRequisiteImpl
    with RequiresAttribute
    with AlchemistBonusFeat
    with Passive {
  self: GeneralFeat =>
//  private[this] val cls = (Alchemist, 12)
  override val requiresAttribute = Seq((Attribute.Dexterity, 13))

}

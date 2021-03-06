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

import java.time.Duration

import io.truthencode.ddo.activation.AtWillEvent
import io.truthencode.ddo.model.attribute.Attribute
import io.truthencode.ddo.model.classes.HeroicCharacterClass
import io.truthencode.ddo.model.classes.HeroicCharacterClass.Ranger
import io.truthencode.ddo.support.requisite._

/**
  * Icon Feat Many Shot.png
  * [[https://ddowiki.com/page/Manyshot Manyshot]]
  * Active - Ability
  * For the next 20 seconds, add your base attack bonus * 4 to your Doubleshot and Ranged power.
  * This ability puts Ten Thousand Stars on a 30 second cooldown.
  *
  * Cooldown: 2 minutes.
  *
  * Point Blank Shot, Rapid Shot
  * Dexterity 17, Base Attack Bonus +6
  *
  * @note This feat does not work with thrown weapons or crossbows.
  * Rangers receive this feat for free at level 6, even if the prerequisites are not met.
  * Using this ability places Ten Thousand Stars on a 30 second cool-down if its current cool-down is less than 30 seconds.
  * Tip: Increase your Base attack bonus, for example using Tenser's Transformation, to receive maximum benefit from this feat.
  * Fighters may select this feat as one of their fighter bonus feats.
  *
  * @todo add 20 second Active
  */
protected[feats] trait Manyshot
    extends FeatRequisiteImpl
    with ActiveFeat
    with AtWillEvent
    with RequiresAllOfFeat
    with RequiresAttribute
    with RequiresBaB
    with ClassRequisiteImpl
    with GrantsToClass
    with FighterBonusFeat {
  self: GeneralFeat =>
  override def allOfFeats: Seq[GeneralFeat] =
    List(GeneralFeat.PointBlankShot, GeneralFeat.RapidShot)

  /**
    * The Minimum Required Base Attack Bonus
    *
    * @return Minimum value allowed
    */
  override def requiresBaB: Int = 6

  override def requiresAttribute: Seq[(Attribute, Int)] =
    List((Attribute.Dexterity, 17))

  override def grantToClass: Seq[(HeroicCharacterClass, Int)] =
    List((Ranger, 6))

  override def coolDown: Option[Duration] = Some(Duration.ofMinutes(2))
}

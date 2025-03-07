/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * Copyright 2015-2025
 *
 * Author: Andre White.
 * FILE: TurnUndead.scala
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

import io.truthencode.ddo.activation.{AtWillEvent, TriggeredActivationImpl}
import io.truthencode.ddo.model.classes.HeroicCharacterClass
import io.truthencode.ddo.support.requisite.{FeatRequisiteImpl, GrantsToClass, RequiresAnyOfClass}

import java.time.Duration

protected[feats] trait TurnUndead
  extends FeatRequisiteImpl with TriggeredActivationImpl with ActiveFeat with AtWillEvent
  with GrantsToClass with RequiresAnyOfClass {
  self: Feat =>
  /* DDOWiki lists Bane of Undead as a prerequisite.  I am doing the other way around
       I.e. Bane of undead Grants the Feat:Turn Undead as the description suggests.
       We could implement as AutoGrant to: ED Bane of Undead, however, I do not wish to create cyclic
       references between Feats and Destinies.  Rather, I would have a Turn Dead Effect / Feature
       which is granted by the feat, and the Feat is also granted by spending Fate Points for Bane of Undeath.
   */
  override def coolDown: Option[Duration] = Some(Duration.ofSeconds(1))

  override def grantToClass: Seq[(HeroicCharacterClass, Int)] = {
    Seq((HeroicCharacterClass.Cleric, 1), (HeroicCharacterClass.Paladin, 4))
  }

  override def anyOfClass: Seq[(HeroicCharacterClass, Int)] = {
    Seq((HeroicCharacterClass.Cleric, 1), (HeroicCharacterClass.Paladin, 4))

  }
}

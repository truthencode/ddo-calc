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

import io.truthencode.ddo.model.classes.HeroicCharacterClass
import io.truthencode.ddo.model.classes.HeroicCharacterClass.Artificer
import io.truthencode.ddo.model.feats.ClassFeat.ImprovedConstructEssence
import io.truthencode.ddo.model.race.Race
import io.truthencode.ddo.model.race.Race.Warforged
import io.truthencode.ddo.support.requisite.{RequiresAllOfClass, RequiresAllOfFeat, RequiresNoneOfRace}

/**
 * Created by adarr on 4/3/2017.
 */
protected[feats] trait ConstructExemplar
  extends ClassRestricted with RequiresAllOfClass with RequiresNoneOfRace with RequiresAllOfFeat
  with Passive {
  self: EpicFeat =>
  override def allOfFeats: Seq[Feat] = List(ImprovedConstructEssence)

  override def noneOfRace: Seq[(Race, Int)] = List((Warforged, 1))

  override def allOfClass: Seq[(HeroicCharacterClass, Int)] = List((Artificer, 12))
}

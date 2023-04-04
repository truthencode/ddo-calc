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

import io.truthencode.ddo.activation.AtWillEvent
import io.truthencode.ddo.model.classes.HeroicCharacterClass
import io.truthencode.ddo.model.classes.HeroicCharacterClass.Artificer
import io.truthencode.ddo.model.misc.DefaultCasterCoolDown
import io.truthencode.ddo.support.requisite.{FeatRequisiteImpl, GrantsToClass, RequiresAllOfClass}

/**
 * Created by adarr on 2/16/2017.
 * [[https://ddowiki.com/page/Inscribe_Artificer_Scroll Inscribe Artificer Scroll]] You are able to
 * inscribe artificer spells from scrolls into your spellbook. This action will destroy the scroll.
 */
trait InscribeArtificerScroll
  extends FeatRequisiteImpl with ActiveFeat with AtWillEvent with RequiresAllOfClass
  with GrantsToClass with DefaultCasterCoolDown {
  override def allOfClass: Seq[(HeroicCharacterClass, Int)] =
    List((Artificer, 1))
  override def grantToClass: Seq[(HeroicCharacterClass, Int)] =
    List((Artificer, 1))
}

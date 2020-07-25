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
package io.truthencode.ddo.model.feats.races

import io.truthencode.ddo.model.feats.{ConcordionResourcesBundleSpec, RaceSupport}
import io.truthencode.ddo.model.race.Race
import org.concordion.api.ConcordionResources
import org.concordion.integration.junit4.ConcordionRunner
import org.junit.runner.RunWith

// @ConcordionResources(Array("/images/thumb/*.png", "/images/*.png"))
@RunWith(classOf[ConcordionRunner])
class ElfFeatSpec extends ConcordionResourcesBundleSpec with RaceSupport {
  override val raceId = Race.Elf

}
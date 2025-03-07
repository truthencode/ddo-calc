/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * Copyright 2015-2025
 *
 * Author: Andre White.
 * FILE: SLARapidCondensation.scala
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
package io.truthencode.ddo.model.enhancement.enhancements

import io.truthencode.ddo.model.enhancement.enhancements.classbased.BombardierTierTwo
import io.truthencode.ddo.support.naming.{DisplayName, DisplayProperties, SLAPrefix}

trait SLARapidCondensation extends BombardierTierTwo with ClassEnhancementImpl with SLAPrefix {
  self: DisplayName & DisplayProperties =>

  /**
   * Some enhancements can be taken multiple times (generally up to three)
   */
  override val ranks: Int = 3

  override def displayText: String = withPrefix.getOrElse("") + nameSource

  override protected def nameSource: String = "Rapid Condensation"

  /**
   * Some enhancements have multiple ranks. This is the cost for each rank. Older versions had
   * increasing costs which has been streamlined to a linear progression.
   *
   * @return
   */
  override def apCostPerRank: Int = 1
}

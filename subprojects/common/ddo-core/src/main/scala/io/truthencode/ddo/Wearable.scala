/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * Copyright 2015-2025
 *
 * Author: Andre White.
 * FILE: Wearable.scala
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
package io.truthencode.ddo
import enumeratum.EnumEntry
import io.truthencode.ddo.enumeration.EnumExtensions.{E2, EnumCompanionOps}
import io.truthencode.ddo.support.slots.WearLocation

/**
 * Indicates the given object can be equipped / wielded etc.
 */
trait Wearable {

  /**
   * A list of allowed location slots
   *
   * Slots are determined by default using the allowedWearLocationFlags bitmask.
   */
  lazy val equipmentSlot: Seq[EnumEntry] = {
    WearLocation.withName("blah").foo
    WearLocation.fromMask(allowedWearLocationFlags) match {
      case Some(x: Seq[EnumEntry]) => x
      case _ => List[WearLocation & Product & Serializable]()
    }
  }

  /**
   * A bitmask that corresponds to one or more [io.truthencode.ddo.WearLocation] values.
   */
  def allowedWearLocationFlags: Int
}

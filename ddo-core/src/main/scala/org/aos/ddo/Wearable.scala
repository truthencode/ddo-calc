/**
 * Copyright (C) 2015 Andre White (adarro@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.aos.ddo
import enumeratum.EnumEntry
import org.aos.ddo.enumeration.EnumExtensions._

/** Indicates the given object can be equipped / wielded etc.
  */
trait Wearable {
  /** A list of allowed location slots
    *
    * Slots are determined by default using the allowedWearLocationFlags bitmask.
    */
  lazy val equipmentSlot: Seq[EnumEntry] = {
    WearLocation.fromMask(allowedWearLocationFlags) match {
      case Some(x) => x
      case _       => List[WearLocation with Product with Serializable]()
    }
  }

  /** A bitmask that corresponds to one or more [org.aos.ddo.WearLocation] values.
    */
  def allowedWearLocationFlags: Int
}

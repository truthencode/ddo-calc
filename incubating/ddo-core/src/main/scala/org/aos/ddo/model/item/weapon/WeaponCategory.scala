/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * Copyright 2015-2019 Andre White.
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
/**
  * Copyright (C) 2015 Andre White (adarro@gmail.com)
  *
  * Licensed under the Apache License, Version 2.0 (the "License");
  * you may not use this file except in compliance with the License.
  * You may obtain a copy of the License at
  *
  * http://www.apache.org/licenses/LICENSE-2.0
  *
  * Unless required by applicable law or agreed to in writing, software
  * distributed under the License is distributed on an "AS IS" BASIS,
  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  * See the License for the specific language governing permissions and
  * limitations under the License.
  */
package io.truthencode.ddo.model.item.weapon

import enumeratum.{Enum, EnumEntry}
import io.truthencode.ddo.Damage
import io.truthencode.ddo.support.naming.{DisplayName, FriendlyDisplay}
import io.truthencode.ddo.support.{Bludgeoning, Piercing, Slashing}
import io.truthencode.ddo.support.StringUtils.Extensions

import scala.collection.immutable.IndexedSeq

/**
  * Enumerates the specific base types of weapons available in DDO, i.e. Kopesh, Dagger etc.
  */
sealed trait WeaponCategory
    extends EnumEntry
    with Damage
    with DefaultDeliveryMethod
    with DisplayName
    with FriendlyDisplay {

  /**
    * Sets or maps the source text for the DisplayName.
    *
    * @return Source text.
    */
  override protected def nameSource: String =
    entryName.splitByCase.toPascalCase
}

// scalastyle:off number.of.types number.of.methods
/**
  * Holds the basic (Default) weapon types, swords, axes etc.
  *
  * @todo Handle orbs and rune arms, orbs should be shields,
  *       but rune arm is only off-hand only with non-physical damage
  */
object WeaponCategory extends Enum[WeaponCategory] {

  case object BastardSword
      extends WeaponCategory
      with ExoticWeapon
      with MeleeDamage
      with Slashing

  case object BattleAxe
      extends WeaponCategory
      with MartialWeapon
      with MeleeDamage
      with Slashing

  case object Club
      extends WeaponCategory
      with SimpleWeapon
      with MeleeDamage
      with Bludgeoning

  case object Dagger
      extends WeaponCategory
      with SimpleWeapon
      with MeleeDamage
      with Piercing

  case object Dart
      extends WeaponCategory
      with SimpleWeapon
      with MeleeDamage
      with Piercing

  case object DwarvenWarAxe
      extends WeaponCategory
      with ExoticWeapon
      with MeleeDamage
      with Piercing {

    /**
      * Sets or maps the source text for the DisplayName.
      *
      * @return Source text.
      */
    override protected def nameSource: String = "Dwarven Axe".toPascalCase
  }

  case object Falchion
      extends WeaponCategory
      with MartialWeapon
      with MeleeDamage
      with Slashing

  case object GreatAxe
      extends WeaponCategory
      with MartialWeapon
      with MeleeDamage
      with Slashing

  case object GreatClub
      extends WeaponCategory
      with MartialWeapon
      with MeleeDamage
      with Bludgeoning

  //
  case object GreatCrossbow
      extends WeaponCategory
      with ExoticWeapon
      with RangeDamage
      with Piercing

  case object Greatsword
      extends WeaponCategory
      with MartialWeapon
      with MeleeDamage
      with Slashing

  case object HandAxe
      extends WeaponCategory
      with MartialWeapon
      with MeleeDamage
      with Slashing

  case object Handwrap
      extends WeaponCategory
      with SimpleWeapon
      with MeleeDamage
      with Bludgeoning

  case object HeavyCrossbow
      extends WeaponCategory
      with SimpleWeapon
      with MeleeDamage
      with Piercing

  case object HeavyMace
      extends WeaponCategory
      with SimpleWeapon
      with MeleeDamage
      with Slashing

  case object HeavyPick
      extends WeaponCategory
      with MartialWeapon
      with MeleeDamage
      with Piercing

  case object Kama
      extends WeaponCategory
      with ExoticWeapon
      with MeleeDamage
      with Slashing

  case object Khopesh
      extends WeaponCategory
      with ExoticWeapon
      with MeleeDamage
      with Slashing

  case object Kukris
      extends WeaponCategory
      with MartialWeapon
      with MeleeDamage
      with Slashing

  case object LightCrossbow
      extends WeaponCategory
      with SimpleWeapon
      with RangeDamage
      with Piercing

  case object LightHammer
      extends WeaponCategory
      with MartialWeapon
      with MeleeDamage
      with Bludgeoning

  case object LightMace
      extends WeaponCategory
      with SimpleWeapon
      with MeleeDamage
      with Bludgeoning

  case object LightPick
      extends WeaponCategory
      with MartialWeapon
      with MeleeDamage
      with Piercing

  case object Longbow
      extends WeaponCategory
      with MartialWeapon
      with RangeDamage
      with Piercing

  case object Longsword
      extends WeaponCategory
      with MartialWeapon
      with MeleeDamage
      with Slashing

  case object Maul
      extends WeaponCategory
      with MartialWeapon
      with MeleeDamage
      with Bludgeoning

  case object Morningstar
      extends WeaponCategory
      with SimpleWeapon
      with MeleeDamage
      with Bludgeoning

  case object Quarterstaff
      extends WeaponCategory
      with SimpleWeapon
      with MeleeDamage
      with Bludgeoning

  case object Rapier
      extends WeaponCategory
      with MartialWeapon
      with MeleeDamage
      with Piercing

  case object RepeatingHeavyCrossbow
      extends WeaponCategory
      with ExoticWeapon
      with RangeDamage
      with Piercing

  case object RepeatingLightCrossbow
      extends WeaponCategory
      with ExoticWeapon
      with RangeDamage
      with Piercing

  // case object RuneArm extends WeaponCategory
  case object Scimitar
      extends WeaponCategory
      with MartialWeapon
      with MeleeDamage
      with Slashing

  case object Shortbow
      extends WeaponCategory
      with MartialWeapon
      with RangeDamage
      with Piercing

  case object Shortsword
      extends WeaponCategory
      with MartialWeapon
      with MeleeDamage
      with Piercing

  case object Shuriken
      extends WeaponCategory
      with ExoticWeapon
      with ThrownDamage
      with Piercing

  case object Sickle
      extends WeaponCategory
      with SimpleWeapon
      with MeleeDamage
      with Slashing

  case object SimpleProjectile
      extends WeaponCategory
      with SimpleWeapon
      with ThrownDamage
      with Bludgeoning

  case object ThrowingAxe
      extends WeaponCategory
      with MartialWeapon
      with ThrownDamage
      with Slashing

  case object ThrowingDagger
      extends WeaponCategory
      with SimpleWeapon
      with ThrownDamage
      with Piercing

  case object ThrowingHammer
      extends WeaponCategory
      with MartialWeapon
      with ThrownDamage
      with Bludgeoning

  case object Warhammer
      extends WeaponCategory
      with MartialWeapon
      with Product
      with Serializable
      with MeleeDamage
      with Bludgeoning

  //  RuneArm,
  lazy val values: IndexedSeq[WeaponCategory] = findValues

  def exoticWeapons: Seq[WeaponCategory with ExoticWeapon] = {
    for {
      w <- WeaponCategory.values.filter { x =>
        x match {
          case _: ExoticWeapon => true
          case _ => false
        }
      }
    } yield w.asInstanceOf[WeaponCategory with ExoticWeapon]
  }

  def martialWeapons: Seq[WeaponCategory with MartialWeapon] = {
    for {
      w <- WeaponCategory.values.filter { x =>
        x match {
          case _: MartialWeapon => true
          case _ => false
        }
      }
    } yield w.asInstanceOf[WeaponCategory with MartialWeapon]
  }

  def simpleWeapons: Seq[WeaponCategory with SimpleWeapon] = {
    for {
      w <- WeaponCategory.values.filter { x =>
        x match {
          case _: SimpleWeapon => true
          case _ => false
        }
      }
    } yield w.asInstanceOf[WeaponCategory with SimpleWeapon]
  }

}

// scalastyle:on number.of.types number.of.methods

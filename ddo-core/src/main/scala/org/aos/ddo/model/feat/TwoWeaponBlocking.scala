package org.aos.ddo.model.feat

import org.aos.ddo.support.requisite.{FeatRequisiteImpl, RequiresAllOfFeat}

/** Icon Feat Two Weapon Blocking.png
  * Two Weapon Blocking 	Passive 	Increases amount of damage you can block when defending with two weapons. ( This bonus does not apply when fighting unarmed/with handwraps.)
  * *
  * Two Weapon Fighting
  * */
trait TwoWeaponBlocking extends FeatRequisiteImpl with Passive with RequiresAllOfFeat {
  self: Feat =>
  override def allOfFeats: Seq[Feat] = List(Feat.TwoWeaponFighting)
}

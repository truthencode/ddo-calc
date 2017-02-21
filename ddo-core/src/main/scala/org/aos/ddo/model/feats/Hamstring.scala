package org.aos.ddo.model.feats

import org.aos.ddo.support.requisite.{FeatRequisiteImpl, RequiresAllOfFeat}

/** Icon Feat Hamstring.png
  * Hamstring 	Active - Special Attack 	This melee special attack, when successful, reduces the target's movement rate by half for 12 seconds.
  * Some creatures may be immune to the hamstring effect.
  *
  * Sneak Attack
  */
protected[feats] trait Hamstring extends FeatRequisiteImpl with Active with RequiresAllOfFeat {
  self: GeneralFeat =>
  override val allOfFeats = List(ClassFeat.SneakAttack)
}
package org.aos.ddo.model.feat

import org.aos.ddo.model.classes.CharacterClass
import org.aos.ddo.model.item.weapon.WeaponClass
import org.aos.ddo.support.requisite.{FeatRequisiteImpl, RequiresAllOfClass, RequiresAllOfFeat}

/** Icon Feat Greater Weapon Specialization.png
  * Greater Weapon Specialization 	Passive 	Provides an additional +2 bonus to damage rolls with the chosen weapon type and +2 stacking Melee Power or Ranged Power. This bonus stacks with the Weapon Specialization feat.
  * *
  *
  * @todo Weapon Focus
  *       Weapon Specialization in same Weapon Type
  **/
protected[feat] trait GreaterWeaponSpecialization extends FeatRequisiteImpl with Passive with RequiresAllOfClass {

  self: Feat with WeaponClass with RequiresAllOfFeat =>

  override def allOfClass: Seq[(CharacterClass, Int)] = List((CharacterClass.Fighter, 12))
}

package org.aos.ddo.model.feats

import org.aos.ddo.model.classes.CharacterClass
import org.aos.ddo.model.classes.CharacterClass.Warlock
import org.aos.ddo.support.requisite.{FeatRequisiteImpl, GrantsToClass, RequiresAllOfClass, RequiresAllOfFeat}

/**
  * Adds the spell Rage to your spellbook @ Level 2
  */
protected[feats] trait PactMagicRage
    extends FeatRequisiteImpl
    with Passive
    with RequiresAllOfClass
    with GrantsToClass
    with PactMagicPrefix with RequiresAllOfFeat { self: ClassFeat =>
  override protected def nameSource: String = "Rage"

  override def grantToClass: Seq[(CharacterClass, Int)] = List((Warlock, 5))

   override def allOfFeats: Seq[Feat] = List(ClassFeat.PactFiend)
}
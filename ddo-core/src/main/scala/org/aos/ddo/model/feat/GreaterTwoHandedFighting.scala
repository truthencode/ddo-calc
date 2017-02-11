package org.aos.ddo.model.feat

import org.aos.ddo.model.attribute.Attribute
import org.aos.ddo.support.requisite.{FeatRequisiteImpl, RequiresAllOfFeat, RequiresAttribute, RequiresBaB}

/** Icon Feat Greater Two Handed Fighting.png
  * Greater Two Handed Fighting 	Passive 	Increases the damage of glancing blow attacks when wielding a two-handed weapon by an additional 10% for a total of 50%. Also increases the chance for weapon effects to trigger on glancing blows by an additional 3% (9%) and an additional +2 to Melee Power (total of +6).
  * *
  * Improved Two Handed Fighting
  * Strength 17
  * Base Attack Bonus +11
  * *
  */
trait GreaterTwoHandedFighting extends FeatRequisiteImpl with Passive with RequiresAllOfFeat with RequiresAttribute with RequiresBaB {
  self: Feat =>
  override def requiresAttribute: Seq[(Attribute, Int)] = List((Attribute.Strength, 17))

  override def requiresBaB = 11

  override def allOfFeats: Seq[Feat] = List(Feat.ImprovedTwoHandedFighting)
}

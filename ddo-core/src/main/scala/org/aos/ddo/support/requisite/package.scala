package org.aos.ddo.support

import org.aos.ddo.model.attribute.Attribute
import org.aos.ddo.model.classes.CharacterClass
import org.aos.ddo.model.feat.Feat
import org.aos.ddo.model.race.Race
import org.aos.ddo.model.skill.Skill
import org.aos.ddo.support.requisite.Requirement._

/**
  * Created by adarr on 1/30/2017.
  */
package object requisite {
  type Result = (Boolean, Option[List[Requisite]])

  object RequirementImplicits {

    implicit class SkillImplicits(val source: (Skill, Int)) {
      def toReq: ReqSkill = skillToReq(source)
    }

    val skillToReq = new PartialFunction[(Skill, Int), ReqSkill] {
      override def isDefinedAt(x: (Skill, Int)): Boolean =
        Requirement.withNameOption(s"${Skill.searchPrefix}${x._1.entryName}").isDefined

      override def apply(v1: (Skill, Int)): ReqSkill = ReqSkill(v1._1.entryName, v1._2)
    }

    implicit class AttributeImplicits(val source: (Attribute, Int)) {
      def toReq: ReqAttribute = attrToReq(source)
    }

    val attrToReq = new PartialFunction[(Attribute, Int), ReqAttribute] {
      override def isDefinedAt(x: (Attribute, Int)): Boolean =
        Requirement.withNameOption(s"${Attribute.searchPrefix}${x._1.entryName}").isDefined

      override def apply(v1: (Attribute, Int)): ReqAttribute = ReqAttribute(v1._1.entryName, v1._2)
    }

    implicit class RaceImplicits(val source: (Race, Int)) {
      def toReq: ReqRace = raceToReq(source)
    }

    val raceToReq = new PartialFunction[(Race, Int), ReqRace] {
      override def isDefinedAt(x: (Race, Int)): Boolean =
        Requirement.withNameOption(s"${Race.searchPrefix}${x._1.entryName}").isDefined

      override def apply(v1: (Race, Int)): ReqRace = ReqRace(v1._1.entryName, v1._2)
    }

    implicit class FeatImplicits(val source: Feat) {
      def toReq: ReqFeat = featToReq(source)
    }

    val featToReq = new PartialFunction[Feat, ReqFeat] {
      override def isDefinedAt(x: Feat): Boolean =
        Requirement.withNameOption(s"${Feat.searchPrefix}${x.entryName}").isDefined

      override def apply(v1: Feat): ReqFeat = ReqFeat(v1.entryName)
    }

    implicit class ClassImplicits(val source: (CharacterClass, Int)) {
      def toReq: ReqClass = classToReq(source)
    }

    val classToReq = new PartialFunction[(CharacterClass, Int), ReqClass] {
      override def isDefinedAt(x: (CharacterClass, Int)): Boolean =
        Requirement.withNameOption(s"${CharacterClass.searchPrefix}${x._1.entryName}").isDefined

      override def apply(v1: (CharacterClass, Int)): ReqClass = ReqClass(v1._1.entryName, v1._2)
    }


  }

}

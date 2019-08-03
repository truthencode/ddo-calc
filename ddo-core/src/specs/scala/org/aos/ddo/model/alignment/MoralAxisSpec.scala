package org.aos.ddo.model.alignment

import org.aos.ddo.support.{ConcordionEnumBuilderHelper, ConcordionEnumBuilderSupport}
import org.concordion.api.FullOGNL
import org.concordion.api.extension.Extensions
import org.concordion.ext.EmbedExtension
import org.concordion.integration.junit4.ConcordionRunner
import org.junit.runner.RunWith

@RunWith(classOf[ConcordionRunner])
@FullOGNL
@Extensions(Array(classOf[EmbedExtension]))
class MoralAxisSpec {

  val helper: ConcordionEnumBuilderSupport = new ConcordionEnumBuilderSupport {
    override def actual: Seq[String] = MoralAxis.values.map(_.toString)
  }

  val rows: scala.collection.mutable.SortedSet[String] = scala.collection.mutable.TreeSet.empty

  def setUpRow(value: String): Unit = {
    rows += value
  }

  def getCaseSensitive: String = "Values can be located / limited in a case-sensitive manner"

  def getCaseInSensitive: String = "Values can be located / limited in a case-insensitive manner"

  def getInvalidValues: String = "Invalid values should be handled gracefully"


}

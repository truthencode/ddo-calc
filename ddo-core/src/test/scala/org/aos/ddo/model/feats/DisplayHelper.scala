package org.aos.ddo.model.feats

import java.util

import enumeratum.{Enum, EnumEntry}
import org.aos.ddo.support.naming.FriendlyDisplay
import scala.collection.JavaConverters._

/**
  * Created by adarr on 2/17/2017.
  */
trait DisplayHelper {
  type Entry = EnumEntry with SubFeatInformation with FriendlyDisplay
  type E = Enum[_ <: Entry]

  val enum: E

  def prettyPrint(): String = {
    listValues("Current Supported Feats", collapse = true)
  }

  def verify(): util.List[String] =
    enum.values
      .filter { x =>
        !x.isSubFeat
      }
      .map { x =>
        x.displayText
      }
      .toList
      .sorted
      .asJava

  def listValues(heading: String, collapse: Boolean = false): String = {

    val data = enum.values
      .map { a =>
        s"<tr><td>${a.displayText}</td></tr>"
      }
      .sorted
      .mkString
    val header = s"<table><tr><th>$heading</th></tr>"
    val footer = "</table>"
    val table = s"$header$data$footer"
    if (collapse) {
      s"""<div class=\"collapsible\">$table</div>"""
    } else {
      table
    }
  }

  def withNameAsList(skillId: String): util.List[String] =
    List(withName(skillId).displayText).asJava

  protected def withName(skillId: String): Entry = enum.withName(skillId)
}
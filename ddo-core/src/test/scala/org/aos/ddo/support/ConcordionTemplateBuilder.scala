package org.aos.ddo.support

import com.typesafe.scalalogging.LazyLogging
import de.neuland.jade4j.{Jade4J, JadeConfiguration}
import enumeratum.{Enum, EnumEntry}
import org.aos.ddo.enumeration.Companionable
import org.aos.ddo.support.StringUtils.{Extensions, randomAlphaString}

import scala.collection.JavaConverters.asJavaIterableConverter
import scala.reflect.ClassTag

/**
  * Created by adarr on 8/14/2016.
  */
class ConcordionTemplateBuilder extends LazyLogging {
  val basePath = "/template"
  val config: JadeConfiguration = {
    val c = new JadeConfiguration
    c.setPrettyPrint(true)
    c.setMode(Jade4J.Mode.HTML)
    c.setCaching(false)
    c
  }

  def nameToClass[T: ClassTag](cls: T): Option[Enum[_ <: EnumEntry]] = {
    val cName = cls.getClass.getName
    cls match {
      case x: Companionable => logger.info(s"Casting $cName from Companionable")
        Some(x.companion.asInstanceOf[Enum[_ <: EnumEntry]])
      case x: Enum[_] =>
        logger.info(s"Returning Enum from base")
        Some(x)
      case cls: EnumEntry =>
        logger.info(s"EnumEntry located $cName")
        None
      case x: AnyRef =>
        logger.warn(s"nameToClass resolved $cName")
        None
      case _ => None
    }
  }

  def renderEnum(fqn: String): Option[String] = {
    val path = s"$basePath/Enum.jade"
    val cpPath = getClass.getResource(path).getFile
    logger.info(s"Attempting to load Template file => $cpPath")


    try {
      // WOW!!! Unsafe
      val cls = Class.forName(fqn).newInstance
      val template = config.getTemplate(cpPath)
      nameToClass(cls) match {
        case Some(x) => val model = modelBuilder(x)

          val output = Jade4J.render(template, model)
          logger.info(s"Pretty printing results? ${config.isPrettyPrint} ")
          Option(output)
        case None => logger.error(s"Failed to convert $fqn, could not build model.")
          None
      }
    }
    catch {
      case e: InstantiationException => logger.error(s"Could not instantiate $fqn, ${e.getMessage}")
        None
      case e: Exception => logger.error(s"Failed to render file $cpPath", e)
        None
    }
  }

  /*def findCompanion[E <: Companion[EnumEntry]](entry: E): Enum[_ <: EnumEntry] = {
    entry.comp
  }*/

  def modelBuilder(source: Enum[_]): java.util.HashMap[String, Object] = {
    val model = new java.util.HashMap[String, Object]()

    val name = source.getClass.getSimpleName.filterAlphaNumeric.splitByCase
    val values = source.values.asJava
    val ciValues = source.values.map { x => x.toString.randomCase }.asJava

    val sLen = 10
    val invalid = (for {x <- 0 to 3} yield randomAlphaString(sLen).randomCase).asJava
    val singleValue = source.values.headOption.map { h => h.toString }.getOrElse("Please specify at least one value for this enum")
    model.put("name", name)
    model.put("values", values)
    model.put("invalidValues", invalid)
    model.put("ciValues", ciValues)
    model.put("singleValue", singleValue)

    model
  }
}

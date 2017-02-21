package org.aos.ddo.model.feats

import org.aos.ddo.model.race.Race
import org.aos.ddo.support.requisite.{
  FeatRequisiteImpl,
  RaceRequisite,
  RequiresAllOfRace
}

/**
  * Created by adarr on 2/20/2017.
  */
trait DrowSpellResistance
    extends FeatRequisiteImpl
    with RaceRequisite
    with Passive
    with RequiresAllOfRace {
  override def allOfRace: Seq[(Race, Int)] = List((Race.DrowElf, 1))

  override def grantsToRace: Seq[(Race, Int)] = List((Race.DrowElf, 1))
}
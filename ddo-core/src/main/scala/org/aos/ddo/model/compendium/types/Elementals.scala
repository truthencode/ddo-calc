package org.aos.ddo.model.compendium.types

import org.aos.ddo.model.compendium.types.MonsterType.Elemental

/**
  * Created by adarr on 3/25/2017.
  */
trait Elementals extends MainType {
  override val mainTypes = Some(Elemental)
}
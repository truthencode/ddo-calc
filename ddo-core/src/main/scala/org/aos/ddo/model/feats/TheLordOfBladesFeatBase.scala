package org.aos.ddo.model.feats

import org.aos.ddo.model.religions.{LordOfBlades, Religion}

/**
  * Created by adarr on 5/2/2017.
  */
trait TheLordOfBladesFeatBase extends ReligionFeatBase { self: LordOfBlades =>
  abstract override def allowedReligions: List[Religion] =
    super.allowedReligions ++ List(Religion.LordOfBlades)
}
package org.monkeynuthead.scalajs.tone

import scala.language.implicitConversions

object Types {

  /** <li>Time : 1.40
    * <li>Notation: 4n or 1m or 2t
    * <li>Now Relative: +3n
    * <li>Math: 3n+16n or even complicated expressions ((3n*2)/6 + 1)
    */
  type Time = String

  /** Normal values are within the range [0, 1]. */
  type NormalRange = Double

  implicit def stringToFrequency(s: String): Frequency = Tone.Frequency(s)

}

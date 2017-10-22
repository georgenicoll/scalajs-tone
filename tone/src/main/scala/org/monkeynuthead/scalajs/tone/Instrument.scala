package org.monkeynuthead.scalajs.tone

import scala.scalajs.js

@js.native
trait Instrument extends js.Object {

  import Types._

  /**
    * trigger a single attack an release for:
    *   - note (e.g. "C4")
    *   - duration (e.g. "8n" for 8th note)
    */
  def triggerAttackRelease(note: Frequency,
                           duration: Time,
                           time: Time = "now",
                           velocity: NormalRange = 1.0): Unit = js.native

  /**
    * Trigger a note on for the note:
    *  - note (e.g. "C4")
    */
  def triggerAttack(note: Frequency,
                    time: Time = "now",
                    velocity: NormalRange = 1.0): Unit = js.native

  /**
    * Trigger release of the current note being played.
    */
  def triggerRelease(time: Time = "now"): Unit = js.native

}

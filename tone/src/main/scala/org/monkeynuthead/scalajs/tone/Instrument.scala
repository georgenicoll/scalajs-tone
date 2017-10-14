package org.monkeynuthead.scalajs.tone

import scala.scalajs.js

@js.native
trait Instrument extends js.Object {

  /**
    * trigger a single attack an release for:
    *   - note (e.g. "C4")
    *   - duration (e.g. "8n" for 8th note)
    */
  def triggerAttackRelease(note: String, duration: String): Unit = js.native

  /**
    * Trigger a note on for the note:
    *  - note (e.g. "C4")
    */
  def triggerAttack(note: String): Unit = js.native

  /**
    * Trigger release of the current note being played.
    */
  def triggerRelease(): Unit = js.native

}

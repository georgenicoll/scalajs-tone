package org.monkeynuthead.scalajs.tone

import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobal, JSGlobalScope}

@js.native
@JSGlobal
object Tone extends js.Object {

  @js.native
  class Synth extends js.Object with Instrument {

    def toMaster(): Synth = js.native

  }

}

@js.native
trait Instrument extends js.Object {

  /**
    * trigger a single attack an release for:
    *   - note (e.g. "C4")
    *   - duration (e.g. "8n" for 8th note)
    */
  def triggerAttackRelease(note: String, duration: String): Unit = js.native


}

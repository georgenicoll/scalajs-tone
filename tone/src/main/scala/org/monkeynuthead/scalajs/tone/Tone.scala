package org.monkeynuthead.scalajs.tone

import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobal, JSGlobalScope}

@js.native
@JSGlobal
object Tone extends js.Object {

  @js.native
  class Synth extends js.Object with Outputs with Instrument
  @js.native
  class AMSynth extends js.Object with Outputs with Instrument

}

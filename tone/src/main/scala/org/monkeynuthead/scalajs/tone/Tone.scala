package org.monkeynuthead.scalajs.tone

import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobal, JSGlobalScope}

@js.native
@JSGlobal
object Tone extends js.Object {

  val Transport: Transport = js.native

  @js.native
  def Frequency(value: String): Frequency = js.native
  @js.native
  def Frequency(value: String, units: String): Frequency = js.native
  @js.native
  def Frequency(value: Int): Frequency = js.native
  @js.native
  def Frequency(value: Int, units: String): Frequency = js.native
  @js.native
  def Frequency(value: Double): Frequency = js.native
  @js.native
  def Frequency(value: Double, units: String): Frequency = js.native

  @js.native
  class Synth extends js.Object with Outputs with Monophonic
  @js.native
  class AMSynth extends js.Object with Outputs with Monophonic
  @js.native
  class FMSynth extends js.Object with Outputs with Monophonic
  @js.native
  class PluckSynth extends js.Object with Outputs with Instrument

}

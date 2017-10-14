package org.monkeynuthead.scalajs.tone

import org.monkeynuthead.scalajs.tone.Tone.Synth

import scala.scalajs.js

@js.native
trait Outputs extends js.Object {

  def toMaster(): Synth = js.native

}

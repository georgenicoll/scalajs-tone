package org.monkeynuthead.scalajs.tone

import org.scalajs.dom
import scalatags.JsDom.all._

object ToneTestApp {

  import org.monkeynuthead.scalajs.tone.Types._

  private[tone] def onLoaded(): Unit = {
    //val synth = new Tone.Synth().toMaster()
    //synth
    dom.window.alert("loaded")

    val synth = new Tone.Synth().toMaster()
    synth.triggerAttackRelease("C4", "8n")

    val amSynth = new Tone.AMSynth().toMaster()
    val amSynthDiv = div(
      onmousedown := { (_: dom.MouseEvent) => amSynth.triggerAttack("C4") },
      onmouseup := { (_: dom.MouseEvent) => amSynth.triggerRelease() },
      "AmSynth C4"
    )
    dom.document.body.appendChild(amSynthDiv.render)
  }

  def main(args: Array[String]): Unit = {
    dom.window.onload = (e: dom.Event) => onLoaded()
  }

}

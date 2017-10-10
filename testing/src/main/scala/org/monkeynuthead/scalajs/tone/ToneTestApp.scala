package org.monkeynuthead.scalajs.tone

import org.scalajs.dom

object ToneTestApp {

  private[tone] def onLoaded(): Unit = {
    //val synth = new Tone.Synth().toMaster()
    //synth
    dom.window.alert("loaded")

    val synth = new Tone.Synth().toMaster()
    synth.triggerAttackRelease("C4", "8n")
  }

  def main(args: Array[String]): Unit = {
    dom.window.onload = (e: dom.Event) => onLoaded()
  }

}

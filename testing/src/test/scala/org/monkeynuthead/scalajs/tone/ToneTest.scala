package org.monkeynuthead.scalajs.tone

import org.scalajs.dom
import utest._

import scala.scalajs.js

object ToneTest extends TestSuite {

  override def tests = TestSuite {

    'DocumentExists {
      assert(dom.document != null)
    }

    'WindowExists {
      assert(dom.window != null)
    }

    'CheckDynamicTopLevelTone {
      assert(js.Dynamic.global.window.Tone != null)
    }

    'CheckScalaToneSynthPlays {
      val synth = new Tone.Synth().toMaster()
      assert(synth != null)
      synth.triggerAttackRelease("C6", "16n")
    }

    'CheckScalaAMSynthAttackRelease {
      val amSynth = new Tone.AMSynth().toMaster()
      assert(amSynth != null)
      amSynth.triggerAttack("A4")
      amSynth.triggerRelease()
    }

    'CheckScalaPluckSynthPlays {
      val synth = new Tone.PluckSynth().toMaster()
      assert(synth != null)
      synth.triggerAttackRelease("C4", "8n")
    }

  }

}

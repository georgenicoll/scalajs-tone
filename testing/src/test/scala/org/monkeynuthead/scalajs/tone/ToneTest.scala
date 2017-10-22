package org.monkeynuthead.scalajs.tone

import org.scalajs.dom
import utest._

import scala.scalajs.js

object ToneTest extends TestSuite {

  import org.monkeynuthead.scalajs.tone.Types._

  override def tests = TestSuite {

    'DocumentExists {
      assert(dom.document != null)
    }

    'WindowExists {
      assert(dom.window != null)
    }

    'DynamicTopLevelTone {
      assert(js.Dynamic.global.window.Tone != null)
    }

    'ToneSynth {
      val synth = new Tone.Synth().toMaster()
      assert(synth != null)
      synth.triggerAttackRelease("C6", "16n")
    }

    'AMSynthAttackRelease {
      val amSynth = new Tone.AMSynth().toMaster()
      assert(amSynth != null)
      amSynth.triggerAttack("A4")
      amSynth.triggerRelease()
    }

    'FMSynthPortmento {
      val fmSynth = new Tone.FMSynth().toMaster()
      assert(fmSynth != null)
      fmSynth.portamento = "1s"
      fmSynth.triggerAttack("C4")
      fmSynth.triggerAttack("D4", "1s")
      fmSynth.triggerRelease("2s")
    }

    'PluckSynth {
      val synth = new Tone.PluckSynth().toMaster()
      assert(synth != null)
      synth.triggerAttackRelease("C4", "8n")
    }

    'Transport {
      Tone.Transport.start()
      Tone.Transport.stop()
    }

  }

}

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

    'CheckTopLevelTone {
      assert(js.Dynamic.global.window.Tone != null)
    }

  }

}

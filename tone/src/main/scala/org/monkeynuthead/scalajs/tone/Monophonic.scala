package org.monkeynuthead.scalajs.tone

import scala.scalajs.js

@js.native
trait Monophonic extends js.Object with Instrument {

  import Types._

  var portamento: Time = js.native

}

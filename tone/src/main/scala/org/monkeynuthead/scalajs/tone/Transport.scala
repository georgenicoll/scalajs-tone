package org.monkeynuthead.scalajs.tone

import scala.scalajs.js

@js.native
trait Transport extends js.Object {

  def start(): Unit = js.native

  def stop(): Unit = js.native

}

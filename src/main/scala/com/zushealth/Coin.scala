package com.zushealth

import scala.util.Random
object Coin {

  /** toss method returns a symbol based on random of 0 or 1. Return type is
    * symbol rather than a string as it will be cached per vm.
    *
    * @return
    */
  def toss() = {
    val i = Random.nextInt(2)
    i match {
      case 0 => Symbol("Heads")
      case 1 => Symbol("Tails")
    }
  }
}

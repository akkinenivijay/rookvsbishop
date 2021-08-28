package com.zushealth

import scala.util.Random
object Coin {
  def toss() = {
    val i = Random.nextInt(2)
    i match {
      case 0 => "H"
      case 1 => "T"
    }
  }
}

package com.zushealth

import scala.util.Random

class Utils {

  //Number of sides of a dice.
  private val numberOfDieSides = 6

  def roll(): Int = {
    val roll1 = Random.nextInt(numberOfDieSides) + 1
    val roll2 = Random.nextInt(numberOfDieSides) + 1
    roll1 + roll2
  }

  def toss(): Symbol = {
    val i = Random.nextInt(2)
    i match {
      case 0 => Symbol("Heads")
      case 1 => Symbol("Tails")
    }
  }

  /** Toss and Roll
    *
    * @return
    */
  def tossAndRoll(): (Symbol, Int) = (toss(), roll())

}

object Utils {
  def apply(): Utils = {
    val u = new Utils()
    u
  }
}

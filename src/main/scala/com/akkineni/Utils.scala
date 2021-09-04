package com.akkineni

import scala.util.Random

class Utils {

  //Random Instance
  private var rand: Random = null

  //Number of sides of a dice.
  private val numberOfDieSides = 6

  def roll(): Int = {
    val roll1 = rand.nextInt(numberOfDieSides) + 1
    val roll2 = rand.nextInt(numberOfDieSides) + 1
    roll1 + roll2
  }

  def toss(): Symbol = {
    val i = rand.nextInt(2)
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

  /** Generate all 15 moves up front.
    *
    * @return
    */
  def generate15Moves(): Array[(Symbol, Int)] = {
    Array.tabulate(15)(_ => tossAndRoll())
  }

}

object Utils {
  def apply(rand: Random): Utils = {
    val u = new Utils()
    u.rand = rand
    u
  }
}

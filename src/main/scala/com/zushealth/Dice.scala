package com.zushealth

/** Single Die returning random number 1 -> 6
  *
  * @param sides
  */
final case class Die(sides: Int) {
  def roll(): Int = scala.util.Random.nextInt(sides) + 1
}

object Dice {
  val die1 = Die(6)
  val die2 = Die(6)

  def roll(): Int = {
    die1.roll() + die2.roll()
  }
}

package com.zushealth

object Game extends App {
      println(Dice.roll())
      println(Coin.toss())

      println(Board.state)
      Board.draw()
}

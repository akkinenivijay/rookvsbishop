package com.akkineni

import scala.util.Random

object Main extends App {
  val game: Game = new Game(Utils(Random))
  val endResult: String = game.play()
  println(endResult)
}

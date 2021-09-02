package com.zushealth

object Main extends App {
  val game: Game = new Game(new Utils())
  val endResult: String = game.play()
  println(endResult)
}

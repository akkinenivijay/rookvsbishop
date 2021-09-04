package com.akkineni

object Main extends App {
  val game: Game = new Game(new Utils())
  val endResult: String = game.play()
  println(endResult)
}

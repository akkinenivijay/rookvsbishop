package com.zushealth

object Main extends App {
  val game = new Game(new Utils())
  val endResult: String = game.play()
  println(endResult)
}

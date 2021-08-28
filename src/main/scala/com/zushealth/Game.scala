package com.zushealth

object Game extends App {
  println(Dice.roll())
  println(Coin.toss())

  // There's only one rook and bishop in the game, 
  // instantiating them and assign to the initial board state.
  val rook = new Rook
  val bishop = new Bishop

  Board.addPeice('h', 1, rook)
  Board.addPeice('c', 3, bishop)
  Board.draw()
}

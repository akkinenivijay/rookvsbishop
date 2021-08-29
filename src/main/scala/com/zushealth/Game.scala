package com.zushealth

import scala.util.control.Breaks._

object Game extends App {

  /** There's only one rook and bishop in this chess game, instantiating them
    * and assign to the initial board state of h1 and c3 respectively.
    *
    * The type of rook is `var` instead of `val` as this variable keeps track of
    * the current rook position rather than always asking the `Board` to fetch
    * rook position.
    */
  var rook = new Rook(1, 'h')
  var bishop = new Bishop(3, 'c')
  Board.addPeice(rook)
  Board.addPeice(bishop)
  Board.draw()

  val rounds = 1 to 3
  breakable {
    for (iter <- rounds) {
      if (Board.isEmpty()) {
        Console.err.println("Invalid State of board being empty!")
        break()
      }
      val numberOfMoves = Dice.roll()
      // Lets toss a coin as board is in a non empty state.
      val direction = Coin.toss()
      rook.printPosition()
      printf(
        "Round: %s Direction: %s NumberOfMoves: %s \n",
        iter,
        direction.name,
        numberOfMoves
      )
      Board.removePeice(rook.row, rook.col)
      direction match {
        case 'Heads => {
          rook = rook.moveUp(numberOfMoves)
        }
        case 'Tails => {
          rook = rook.moveRight(numberOfMoves)
        }
      }
      Board.addPeice(rook)
      Board.draw()
    }
  }
}

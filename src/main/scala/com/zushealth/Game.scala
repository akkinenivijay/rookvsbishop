package com.zushealth

import scala.util.control.Breaks._

object Game extends App {

  // There's only one rook and bishop in the game,
  // instantiating them and assign to the initial board state of
  // h1 and c3 respectively.
  val rook = new Rook(1, 'h')
  val bishop = new Bishop(3, 'c')
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

      val numberOfMoves = Dice.roll();
      // Lets toss a coin as board is in a non empty state.
      Coin.toss() match {
        case 'Heads => {
          rook.printPosition()
          printf(
            "Round: %s Direction: %s NumberOfMoves: %s \n",
            iter,
            'Heads.name,
            numberOfMoves
          )
          val newRook = rook.moveUp(numberOfMoves)
          newRook.printPosition()
          // Board.addPeice()
        }
        case 'Tails => {
          printf(
            "Round: %s Direction: %s NumberOfMoves: %s \n",
            iter,
            'Tails.name,
            numberOfMoves
          )
          rook.printPosition()
          val newRook = rook.moveRight(numberOfMoves)
          newRook.printPosition()
        }
      }
    }
  }

}

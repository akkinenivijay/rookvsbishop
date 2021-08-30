package com.zushealth

import scala.util.control.Breaks._
import Console.GREEN

object Game extends App {

  /** There's only one rook and bishop in this chess game, instantiating them
    * and assign to the initial board state of h1 and c3 respectively.
    *
    * The type of rook is `var` instead of `val` as this variable keeps track of
    * the current rook position rather than always asking the `Board` to fetch
    * rook position.
    */

  val rook = new Rook(1, 'h')
  val bishop = new Bishop(3, 'c')
  val board = new Board(rook, bishop)
  println(s"${GREEN}Initial state")
  board.draw()

  @scala.annotation.tailrec
  def recursiveGamePlay(
      rook: Rook,
      bishop: Bishop,
      board: Board,
      iter: Int
  ): String = {
    if (iter == 15) {
      "Rook survived 15 rounds !!!"
    } else if (bishop.capture(rook)) {
      s"Bishop Captured Rook in iteration ${iter} !!"
    } else {
      val numberOfMoves = Dice.roll()
      // Lets toss a coin as board is in a non empty state.
      val direction = Coin.toss()
      board.rook.printPosition()
      printf(
        "Round: %s Direction: %s NumberOfMoves: %s \n",
        iter + 1,
        direction.name,
        numberOfMoves
      )
      val newRook = direction match {
        case Symbol("Heads") => {
          board.rook.moveUp(numberOfMoves)
        }
        case Symbol("Tails") => {
          board.rook.moveRight(numberOfMoves)
        }
      }
      val updatedBoard = new Board(newRook, bishop)
      updatedBoard.draw()
      recursiveGamePlay(newRook, bishop, updatedBoard, iter + 1)
    }
  }

  val endResult = recursiveGamePlay(rook, bishop, board, 0)

  println(endResult)
}

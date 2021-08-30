package com.zushealth

import scala.util.control.Breaks._
import Console.GREEN

object Game extends App {

  /** There's only one rook and bishop in this chess game, instantiating them
    * and assign to the initial board state of h1 and c3 respectively.
    *
    */

  val rook = new Rook(1, 'h')
  val bishop = new Bishop(3, 'c')
  val board = new Board(rook, bishop)
  println(s"${GREEN}Initial state")
  board.draw()

  @scala.annotation.tailrec
  def play(
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
      printf(
        "Rook Col: %s, Row: %s, Round: %s Direction: %s NumberOfMoves: %s \n",
        board.rook.row,
        board.rook.col,
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
      play(newRook, bishop, updatedBoard, iter + 1)
    }
  }

  val endResult = play(rook, bishop, board, 0)

  println(endResult)
}

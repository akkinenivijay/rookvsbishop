package com.zushealth

import scala.Console.GREEN

class Game(val util: Utils) {

  @scala.annotation.tailrec
  private final def loop(
      rook: Rook,
      bishop: Bishop,
      board: Board,
      iteration: Int
  ): String = {
    if (iteration == 15) {
      "Rook survived 15 rounds !!!"
    } else if (bishop.capture(rook))
      s"Bishop Captured Rook in iteration $iteration !!"
    else {
      val (direction, numberOfMoves) = util.tossAndRoll()
      printf(
        "Rook Col: %s, Row: %s, Round: %s Direction: %s NumberOfMoves: %s \n",
        board.rook.row,
        board.rook.col,
        iteration + 1,
        direction.name,
        numberOfMoves
      )
      val newRook = direction match {
        case Symbol("Heads") =>
          board.rook.moveUp(numberOfMoves)
        case Symbol("Tails") =>
          board.rook.moveRight(numberOfMoves)
      }
      val updatedBoard = new Board(newRook, bishop)
      updatedBoard.draw()
      loop(newRook, bishop, updatedBoard, iteration + 1)
    }
  }

  def play(): String = {

    /** There's only one rook and bishop in this chess game, instantiating them
      * and assign to the initial board state of h1 and c3 respectively.
      */
    val rook = new Rook(1, 'h')
    val bishop = new Bishop(3, 'c')
    val board = new Board(rook, bishop)
    println(s"${GREEN}Initial state")
    board.draw()

    loop(rook, bishop, board, 0)
  }
}

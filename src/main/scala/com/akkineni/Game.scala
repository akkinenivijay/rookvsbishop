package com.akkineni

import scala.Console.GREEN

class Game(val util: Utils) {

  @scala.annotation.tailrec
  private final def loop(
      board: Board,
      iteration: Int
  ): String = {
    val rook = board.findRook
    val bishop = board.findBishop
    if (iteration == 15) {
      "Rook survived 15 rounds !!!"
    } else if (bishop.capture(rook))
      s"Bishop Captured Rook in iteration $iteration !!"
    else {
      val (direction, numberOfMoves) = util.tossAndRoll()
      printf(
        "Round: %s Direction: %s NumberOfMoves: %s \n",
        iteration + 1,
        direction.name,
        numberOfMoves
      )
      val newRook = direction match {
        case Symbol("Heads") =>
          rook.moveUp(numberOfMoves)
        case Symbol("Tails") =>
          rook.moveRight(numberOfMoves)
      }
      board.removePiece(rook)
      board.addPiece(newRook)
      board.draw()
      loop(board, iteration + 1)
    }
  }

  def play(): String = {

    /** There's only one rook and bishop in this chess game, instantiating them
      * and assign to the initial board state of h1 and c3 respectively.
      */
    val rook = new Rook(1, 'h')
    val bishop = new Bishop(3, 'c')
    val board = Board(rook, bishop)
    println(s"${GREEN}Initial state")
    board.draw()

    loop(board, 0)
  }
}

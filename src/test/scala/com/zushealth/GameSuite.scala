package com.zushealth

import org.scalatest.funsuite.AnyFunSuite

class GameSuite extends AnyFunSuite {
  test("Game Play") {
    val rook = new Rook(1, 'h')
    val bishop = new Bishop(3, 'c')
    val board = new Board(rook, bishop)
    val endResult = Game.play(rook, bishop, board, 0)
    assert(endResult.contains("Bishop Captured Rook in iteration"))
  }
}

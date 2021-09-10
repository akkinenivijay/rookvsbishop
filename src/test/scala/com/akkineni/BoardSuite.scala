package com.akkineni

import org.scalatest.funsuite.AnyFunSuite

class BoardSuite extends AnyFunSuite {

  test("Board is empty upon initialization") {
    val board = Board()
    assert(board.isEmpty)
  }

  test("Add a Peice to Board") {
    val rook = new Rook(1, 'h')
    val bishop = new Bishop(3, 'c')
    val board = Board(rook, bishop)
    val addedPeice = board.findRook
    assert(addedPeice.row() == rook.row())
  }

  test("Remove a Piece from the Board") {
    val rook = new Rook(1, 'h')
    val bishop = new Bishop(3, 'c')
    val board = Board(rook, bishop)
    board.removePiece(rook)
    val element = board.elementAt(1, 'h')
    assert(element == null)

    // assertThrows[java.lang.IllegalArgumentException] {
    //   val rook = new Rook(1, 'h')
    //   val bishop = new Bishop(3, 'c')
    //   val board = new Board(rook, bishop)
    //   board.removePiece(9, 'h')
    // }

    // assertThrows[java.lang.IllegalArgumentException] {
    //   val rook = new Rook(1, 'h')
    //   val bishop = new Bishop(3, 'c')
    //   val board = new Board(rook, bishop)
    //   board.removePiece(-1, 'h')
    // }

    // assertThrows[java.lang.IllegalArgumentException] {
    //   val rook = new Rook(1, 'h')
    //   val bishop = new Bishop(3, 'c')
    //   val board = new Board(rook, bishop)
    //   board.removePiece(3, 'i')
    // }

    // assertThrows[java.lang.IllegalArgumentException] {
    //   val rook = new Rook(1, 'h')
    //   val bishop = new Bishop(3, 'c')
    //   val board = new Board(rook, bishop)
    //   board.removePiece(3, 'A')
    // }
  }
}

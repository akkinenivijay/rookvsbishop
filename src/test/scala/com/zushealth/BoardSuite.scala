package com.zushealth

import org.scalatest.funsuite.AnyFunSuite

class BoardSuite extends AnyFunSuite {

  test("Board is empty upon initialization") {
    val rook = new Rook(1, 'h')
    val bishop = new Bishop(3, 'c')
    val board = new Board(rook, bishop)
    val isEmpty = board.isEmpty
    assert(!isEmpty)
  }

  test("Add a Peice to Board") {
    val rook = new Rook(1, 'h')
    val bishop = new Bishop(3, 'c')
    val board = new Board(rook, bishop)
    val addedPeice = board.elementAt(1, 'h')
    assert(addedPeice.row() == rook.row())

    assertThrows[java.lang.IllegalArgumentException] {
      val rook = new Rook(1, 'h')
      val bishop = new Bishop(3, 'c')
      val board = new Board(rook, bishop)
      board.addPiece(new Rook(9, 'h'))
    }

    assertThrows[java.lang.IllegalArgumentException] {
      val rook = new Rook(1, 'h')
      val bishop = new Bishop(3, 'c')
      val board = new Board(rook, bishop)
      board.addPiece(new Rook(-1, 'h'))
    }

    assertThrows[java.lang.IllegalArgumentException] {
      val rook = new Rook(1, 'h')
      val bishop = new Bishop(3, 'c')
      val board = new Board(rook, bishop)
      board.addPiece(new Rook(3, 'i'))
    }

    assertThrows[java.lang.IllegalArgumentException] {
      val rook = new Rook(1, 'h')
      val bishop = new Bishop(3, 'c')
      val board = new Board(rook, bishop)
      board.addPiece(new Rook(3, 'A'))
    }
  }

  test("Remove a Piece from the Board") {
    val rook = new Rook(1, 'h')
    val bishop = new Bishop(3, 'c')
    val board = new Board(rook, bishop)
    board.removePiece(1, 'h')
    val element = board.elementAt(1, 'h')
    assert(element == null)

    assertThrows[java.lang.IllegalArgumentException] {
      val rook = new Rook(1, 'h')
      val bishop = new Bishop(3, 'c')
      val board = new Board(rook, bishop)
      board.removePiece(9, 'h')
    }

    assertThrows[java.lang.IllegalArgumentException] {
      val rook = new Rook(1, 'h')
      val bishop = new Bishop(3, 'c')
      val board = new Board(rook, bishop)
      board.removePiece(-1, 'h')
    }

    assertThrows[java.lang.IllegalArgumentException] {
      val rook = new Rook(1, 'h')
      val bishop = new Bishop(3, 'c')
      val board = new Board(rook, bishop)
      board.removePiece(3, 'i')
    }

    assertThrows[java.lang.IllegalArgumentException] {
      val rook = new Rook(1, 'h')
      val bishop = new Bishop(3, 'c')
      val board = new Board(rook, bishop)
      board.removePiece(3, 'A')
    }
  }
}

package com.akkineni

import org.scalatest.funsuite.AnyFunSuite

class PieceSuite extends AnyFunSuite {
  test("Rook move up") {
    val rook = new Rook(1, 'h')
    val newRook = rook.moveUp(7)
    assert(newRook.row() == 8)
  }

  test("Rook move up overflow") {
    val rook = new Rook(1, 'h')
    val newRook = rook.moveUp(9)
    assert(newRook.row() == 2)
  }

  test("Rook move right") {
    val rook = new Rook(1, 'h')
    val newRook = rook.moveRight(8)
    assert(newRook.col() == 'h')
  }

  test("Bishop can capture Rook if it is located diagonally in its path") {
    val rook = new Rook(2, 'b')
    val bishop = new Bishop(3, 'c')
    assert(bishop.capture(rook))
  }

  test(
    "Bishop cannot capture Rook if it does not fall diagonally in its path"
  ) {
    val rook = new Rook(1, 'h')
    val bishop = new Bishop(3, 'c')
    assert(!bishop.capture(rook))
  }

  test(
    "Bishop capture method cannot accept a Type of Rook"
  ) {
    assertThrows[java.lang.IllegalArgumentException] {
      val bishop1 = new Bishop(4, 'd')
      val bishop2 = new Bishop(3, 'c')
      bishop1.capture(bishop2)
    }
  }

  test("Rook capture throws NotImplementedError") {
    assertThrows[NotImplementedError] {
      val rook = new Rook(1, 'h')
      val bishop = new Bishop(3, 'c')
      rook.capture(bishop)
    }
  }

  test("Piece row and col bounds") {
    assertThrows[java.lang.IllegalArgumentException] {
      new Rook(9, 'h')
    }

    assertThrows[java.lang.IllegalArgumentException] {
      new Rook(-1, 'h')
    }

    assertThrows[java.lang.IllegalArgumentException] {
      new Rook(3, 'i')
    }

    assertThrows[java.lang.IllegalArgumentException] {
      new Rook(3, 'A')
    }
  }
}

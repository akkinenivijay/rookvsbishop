package com.zushealth

class PieceSuite extends munit.FunSuite {
  test("Rook move up") {
    val rook = new Rook(1, 'h')
    val newRook = rook.moveUp(7)
    assertEquals(newRook.row, 8)
  }

  test("Rook move up overflow") {
    val rook = new Rook(1, 'h')
    val newRook = rook.moveUp(9)
    assertEquals(newRook.row, 2)
  }

  test("Rook move right") {
    val rook = new Rook(1, 'h')
    val newRook = rook.moveRight(8)
    assertEquals(newRook.col, 'h')
  }

  test("Bishop can capture Rook if it is located diagonally in its path") {
    val rook = new Rook(2, 'b')
    val bishop = new Bishop(3, 'c')
    assertEquals(bishop.capture(rook), true)
  }

  test(
    "Bishop cannot capture Rook if it does not fall diagonally in its path"
  ) {
    val rook = new Rook(1, 'h')
    val bishop = new Bishop(3, 'c')
    assertEquals(bishop.capture(rook), false)
  }

  test(
    "Bishop capture method cannot accept a Type of Rook"
  ) {
    interceptMessage[java.lang.IllegalArgumentException](
      "Bishop's capture method takes only Rook as type input!!"
    ) {
      val bishop1 = new Bishop(4, 'd')
      val bishop2 = new Bishop(3, 'c')
      bishop1.capture(bishop2)
    }
  }

  test("Rook capture throws NotImplementedError") {
    intercept[NotImplementedError] {
      val rook = new Rook(1, 'h')
      val bishop = new Bishop(3, 'c')
      rook.capture(bishop)
    }
  }
}

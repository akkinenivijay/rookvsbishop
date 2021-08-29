package com.zushealth

class BoardSuite extends munit.FunSuite {

  test("Board is empty upon intialization") {
    val isEmpty = Board.isEmpty()
    assertEquals(isEmpty, true)
  }

  test("Add a Peice to Board") {
    val x = Board.addPeice(new Rook(1, 'h'))
    val addedPeice = Board.state(0)(7).get
    assertEquals(addedPeice.row, x.get.row)
    assertEquals(addedPeice.col, x.get.col)

    interceptMessage[java.lang.IllegalArgumentException](
      "row must be in the range of 1 to 8"
    ) {
      Board.addPeice(new Rook(9, 'h'))
    }

    interceptMessage[java.lang.IllegalArgumentException](
      "row must be in the range of 1 to 8"
    ) {
      Board.addPeice(new Rook(-1, 'h'))
    }

    interceptMessage[java.lang.IllegalArgumentException](
      "col must be in the range of 'a' to 'h'"
    ) {
      Board.addPeice(new Rook(3, 'i'))
    }

    interceptMessage[java.lang.IllegalArgumentException](
      "col must be in the range of 'a' to 'h'"
    ) {
      Board.addPeice(new Rook(3, 'A'))
    }
  }

  test("Remove a Peice from the Board") {
    Board.removePeice(1, 'h')
    val element = Board.state(0)(7)
    assertEquals(element, None)

    interceptMessage[java.lang.IllegalArgumentException](
      "row must be in the range of 1 to 8"
    ) {
      Board.removePeice(9, 'h')
    }

    interceptMessage[java.lang.IllegalArgumentException](
      "row must be in the range of 1 to 8"
    ) {
      Board.removePeice(-1, 'h')
    }

    interceptMessage[java.lang.IllegalArgumentException](
      "col must be in the range of 'a' to 'h'"
    ) {
      Board.removePeice(3, 'i')
    }

    interceptMessage[java.lang.IllegalArgumentException](
      "col must be in the range of 'a' to 'h'"
    ) {
      Board.removePeice(3, 'A')
    }
  }
}

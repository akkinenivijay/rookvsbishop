package com.zushealth

/** Board object represents a singleton instance of chess board representing the
  * current state of the game.
  */
object Board {

  // An 8*8 chess board
  val rowCount, colCount = 8
  val state = Array.ofDim[Piece](rowCount, colCount)

  def addPeice(col: Char, row: Int, piece: Piece) {
    if (col > 'h' | col < 'a')
      throw new IllegalArgumentException(
        "col must be in the range of 'a' to 'h' "
      )
    if (row < 1 | row > 8)
      throw new IllegalArgumentException(
        "row must be in the range of 1 to 8 "
      )
    state(row - 1)(col - 'a') = piece
  }

  /** Renders the current state of the board. Weird printf below is padding
    * position+piece_whitespaces to a fixed length 10 chars.
    */
  def draw() = {
    for (row <- 8 to 1 by -1) {
      for (col <- 'a' to 'h') {

        val position: String = col.toString + row.toString
        val piece: Piece = state(row - 1)(col - 'a')

        piece match {
          //Liskov substitution principle
          case _: Bishop =>
            printf("%s %s ", position, piece)
          case _: Rook =>
            printf("%s %s %s", position, piece, "  ")
          case null => printf("%s %s %s", position, "", "      ")
        }

      }
      println()
    }
  }
}

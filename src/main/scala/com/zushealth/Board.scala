package com.zushealth

/** Board object represents a singleton instance of chess board representing the
  * current state of the game.
  */
object Board {
  // An 8*8 chess board
  val rowCount, colCount = 8
  val state = Array.ofDim[Piece](rowCount, colCount)

  def draw() = {
    for (row <- 8 to 1 by -1) {
      for (col <- 'a' to 'h') {
        printf("%s \t\t", col.toString + row.toString)
      }
      println()
    }
  }
}

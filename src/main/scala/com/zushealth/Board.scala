package com.zushealth

/** Board object represents a singleton instance of chess board representing the
  * current state of the game.
  */
object Board {
  // An 8*8 chess board
  val rowCount, colCount = 8
  val state = Array.ofDim[Piece](rowCount, colCount)
}

package com.zushealth

import scala.util.control.Breaks._

/** Board object represents a singleton instance of chess board representing the
  * current state of the game.
  */
object Board {

  // An 8*8 chess board
  val rowCount, colCount = 8
  val state = Array.ofDim[Option[Piece]](rowCount, colCount)

  //Initialize state of the board to None Type rather than nulls
  for (row <- 8 to 1 by -1) {
    for (col <- 'a' to 'h') {
      state(row - 1)(col - 'a') = None
    }
  }

  def addPeice(col: Char, row: Int, piece: Piece) = {
    if (col > 'h' | col < 'a')
      throw new IllegalArgumentException(
        "col must be in the range of 'a' to 'h' "
      )
    if (row < 1 | row > 8)
      throw new IllegalArgumentException(
        "row must be in the range of 1 to 8 "
      )
    state(row - 1)(col - 'a') = Some(piece)
  }

  /** Checks if the board is empty. This method applies a lambda function
    * _==None to check if the row is empty and breaks out of loop if any row has
    * values other than None.
    *
    * @return
    */
  def isEmpty(): Boolean = {
    var empty = true
    breakable {
      for (row <- 8 to 1 by -1) {
        val rowEmpty = state(row - 1).forall(_ == None)
        if (!rowEmpty) {
          empty = false
          break()
        }
      }
    }
    empty
  }

  /** Renders the current state of the board. Weird printf below is padding
    * position+piece+whitespaces to a fixed length 10 chars.
    */
  def draw() = {
    for (row <- 8 to 1 by -1) {
      for (col <- 'a' to 'h') {
        val position: String = col.toString + row.toString
        state(row - 1)(col - 'a').getOrElse("") match {
          //Liskov substitution principle
          case bishop: Bishop =>
            printf("%s %s ", position, bishop)
          case rook: Rook =>
            printf("%s %s %s", position, rook, "  ")
          case _ => printf("%s %s %s", position, "", "      ")
        }
      }
      println()
    }
  }
}

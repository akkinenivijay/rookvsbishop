package com.akkineni

import scala.util.control.Breaks._

class Board() {

  private val rowCount, colCount = 8
  val state = Array.ofDim[Piece](rowCount, colCount)

  /** Adds an object of Type `Piece` at the given coordinates.
    *
    * @param piece
    *   a chess piee
    */
  def addPiece(piece: Piece): Unit = {
    state(piece.row - 1)(piece.col - 'a') = piece
  }

  /** Removes an object of Type `Piece` at the given coordinates. We may not use
    * this with recursion.
    *
    * @param piece
    *   a piece could be a rook or bishop
    */
  def removePiece(piece: Piece): Unit = {
    state(piece.row - 1)(piece.col - 'a') = null
  }

  /** Finds the current position of the rook and returns the rook piece.
    *
    * @return
    */
  def findRook: Rook = {
    var rook: Piece = null
    breakable {
      for (row <- 1 to 8) {
        val rookInRow = state(row - 1).find(
          _ match {
            case _: Rook => true
            case _       => false
          }
        )
        rookInRow match {
          case Some(x) => {
            rook = x
            break()
          }
          case None =>
        }
      }
    }
    rook.asInstanceOf[Rook]
  }

  /** Finds the current position of the bishop and returns the bishop piece.
    *
    * @return
    */
  def findBishop: Bishop = {
    var bishop: Piece = null
    breakable {
      for (row <- 1 to 8) {
        val bishopInRow = state(row - 1).find(
          _ match {
            case _: Bishop => true
            case _       => false
          }
        )
        bishopInRow match {
          case Some(x) => {
            bishop = x
            break()
          }
          case None =>
        }
      }
    }
    bishop.asInstanceOf[Bishop]
  }

  /** Checks if the board is empty. This method applies a lambda function (_ !=
    * Null) to check if the row is empty and breaks out of loop if any row has
    * values other than None. This method is not needed for our problem but
    * makes a good utility function to check emptiness in case of errros.
    *
    * @return
    */
  def isEmpty: Boolean = {
    var empty = true
    breakable {
      for (row <- 1 to 8) {
        val pieceFound = state(row - 1).exists(_ != null)
        if (pieceFound) {
          empty = false
          break()
        }
      }
    }
    empty
  }

  /** Gets element at coordinate.
    *
    * @param row
    *   row
    * @param col
    *   column
    * @return
    */
  def elementAt(row: Int, col: Char): Piece = {
    state(row - 1)(col - 'a')
  }

  /** Renders the current state of the board. Weird printf below is padding
    * position+piece+whitespaces to a fixed length 10 chars.
    */
  def draw(): Unit = {
    for (row <- 8 to 1 by -1) {
      for (col <- 'a' to 'h') {
        val position: String = col.toString + row.toString
        state(row - 1)(col - 'a') match {
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

object Board {
  def apply(): Board = {
    val b = new Board()
    b
  }

  def apply(pieces: Piece*): Board = {
    val b = new Board()
    for (piece <- pieces) {
      b.addPiece(piece)
    }
    b
  }
}

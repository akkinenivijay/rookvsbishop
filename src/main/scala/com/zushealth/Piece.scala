package com.zushealth

/** Abstract class of Piece type.
  *
  * @param row
  * @param col
  */
abstract class Piece(val row: Int, val col: Char) {

  /** ??? is a language feature to hint that the method is not implemented.
    * Subtypes extending Peice should implement this method or else it throws a
    * NotImplemented Error
    */
  def capture(piece: Piece): Boolean = ???
}

/** Class for Rook Type
  *
  * @param row
  * @param col
  */
class Rook(row: Int, col: Char) extends Piece(row, col) {

  /** Problem statement says both rook and bishop can capture but not very clear
    * on the condition when that happens. Leaving this unimplemented for now.
    *
    * @return
    */
  override def capture(piece: Piece): Boolean = ???

  override def toString: String = "Rook"

  /** Adds the numberOfMoves to the current row and performs a modulus with 8,
    * so that we are handling overflow of indices properly
    *
    * @param numberOfMoves
    * @return
    */
  def moveUp(numberOfMoves: Int): Rook = {
    val overflow = row + numberOfMoves
    if (overflow % 8 == 0)
      new Rook(8, col)
    else
      new Rook(overflow % 8, col)
  }

  def moveRight(numberOfMoves: Int): Rook = {
    val diff = col - 'a'
    val newCol = (((col - 'a' + numberOfMoves) % 8) + 'a').toChar
    new Rook(row, newCol)
  }
}

/** Class for Bishop Type
  *
  * @param row
  * @param col
  */
class Bishop(row: Int, col: Char) extends Piece(row, col) {

  /** Any piece that can get killed by Bishop has an interesting property that
    * it is equi distant on both cols and rows.
    *
    * @param piece
    * @return
    */
  override def capture(piece: Piece): Boolean = {
    piece match {
      case rook: Rook =>
        if (Math.abs(rook.col - col) == Math.abs(rook.row - row))
          true
        else
          false
      case bishop: Bishop =>
        throw new IllegalArgumentException(
          "Bishop's capture method takes only Rook as type input!!"
        )
    }
  }

  override def toString: String = "Bishop"
}

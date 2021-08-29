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
  def capture(): Boolean = ???
  def printPosition(): Unit = ???
}

/** Class for Rook Type
  *
  * @param row
  * @param col
  */
class Rook(row: Int, col: Char) extends Piece(row, col) {

  override def capture(): Boolean = true

  override def toString: String = "Rook"

  /** Adds the numberOfMoves to the current row and performs a modulus with 8,
    * so that we are handling overflow of indices properly
    *
    * @param numberOfMoves
    * @return
    */
  def moveUp(numberOfMoves: Int): Rook = {
    val newRow = (row + numberOfMoves) % 8
    new Rook(newRow, col)
  }

  def moveRight(numberOfMoves: Int): Rook = {
    val diff = col - 'a'
    val newCol = (((col - 'a' + numberOfMoves) % 8) + 'a').toChar
    new Rook(row, newCol)
  }

  override def printPosition(): Unit = {
    printf("Rook Col: %s, Row: %s ", col, row)
  }
}

/** Class for Bishop Type
  *
  * @param row
  * @param col
  */
class Bishop(row: Int, col: Char) extends Piece(row, col) {

  override def capture(): Boolean = ???

  override def toString: String = "Bishop"

  override def printPosition(): Unit = {
    printf("Bishop Col: %s, Row: %s ", col, row)
  }
}

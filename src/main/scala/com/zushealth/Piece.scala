package com.zushealth

trait Piece {

  /** ??? is a language feature to hint that the method is not implemented.
    * Subtypes extending Peice should implement this method or else it throws a
    * NotImplemented Error
    */
  def capture(): Boolean = ???
  val col: Char
  val row: Int
}

case class Rook(row: Int, col: Char) extends Piece {
  override def capture(): Boolean = true
  override def toString: String = "Rook"
}

case class Bishop(row: Int, col: Char) extends Piece {
  override def capture(): Boolean = true
  override def toString: String = "Bishop"
}

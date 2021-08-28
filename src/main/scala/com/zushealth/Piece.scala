package com.zushealth

trait Piece {

  /** ??? is a language feature to hint that the method is not implemented.
    * Subtypes extending Peice should implement this method or else it throws a
    * NotImplemented Error
    */
  def canCapture(): Boolean = ???

  /** the toString method in the parent trait results in the class name being
    * printed by the toString method
    *
    * @return
    */
}

class Rook extends Piece {
  override def canCapture(): Boolean = true
  override def toString: String = "Rook"
}

class Bishop extends Piece {
  override def canCapture(): Boolean = true
  override def toString: String = "Bishop"
}

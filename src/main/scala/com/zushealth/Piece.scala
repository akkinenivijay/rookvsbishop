package com.zushealth

trait Piece {

  /** ??? is a language feature to hint that the method is not implemented.
    * Subtypes extending Peice should implement this method or else it throws a
    * NotImplemented Error
    */
  def canCapture(): Boolean = ???
}

class Rook extends Piece {
  override def canCapture(): Boolean = true
}

class Bishop extends Piece {
  override def canCapture(): Boolean = true
}

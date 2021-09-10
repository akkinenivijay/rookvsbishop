package com.akkineni.learn

import scala.annotation.tailrec

/** Generates a pascal triangle
  */
object PascalTriangle {

  /** Generates a triangle using O(n^2) space and O(n^2) time complexity
    *
    * @param numberOfRows
    *   number of rows.
    * @return
    */
  def generate(numberOfRows: Int): Array[Array[Int]] = {

    val tree: Array[Array[Int]] =
      Array.tabulate(numberOfRows)(n => Array.ofDim[Int](n + 1))
    tree(0)(0) = 1

    @tailrec
    def loop(iter: Int): Array[Array[Int]] = {
      if (iter != numberOfRows) {
        for (col <- tree(iter).indices) {
          if (col == 0 || col == tree(iter).length - 1)
            tree(iter)(col) = 1
          else {
            tree(iter)(col) = tree(iter - 1)(col - 1) + tree(iter - 1)(col)
          }
        }
        loop(iter + 1)
      } else {
        tree
      }
    }
    loop(1)
  }

  /** Prints a triangle using O(n) space and O(n2) time complexity
    *
    * @param numberOfRows
    *   number of rows
    * @return
    */
  def print(numberOfRows: Int): Unit = {

    val inputArray: Array[Int] = Array.ofDim[Int](1)
    inputArray(0) = 1

    @tailrec
    def loop(iter: Int, accumulator: Array[Int]): Unit = {
      println(accumulator.mkString(" "))
      if (iter <= numberOfRows) {
        val newRow = Array.ofDim[Int](iter)
        for (col <- 0 until iter) {
          if (col == 0 || col == iter - 1)
            newRow(col) = 1
          else {
            newRow(col) = accumulator(col - 1) + accumulator(col)
          }
        }
        loop(iter + 1, newRow)
      } else {
        println()
      }
    }
    loop(2, inputArray)
  }
}

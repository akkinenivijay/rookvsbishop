package com.akkineni.learn

import scala.annotation.tailrec

/** return nth Fibonacci number using tail recursive function and also prints
  * numbers.
  */
object Fibonnaci {

  def generate(n: Int): Int = {
    println(0)
    @tailrec
    def loop(n1: Int, n2: Int, iter: Int): Int = {
      if (iter == 2) {
        n2
      } else {
        println(n2)
        loop(n1 = n2, n2 = n1 + n2, iter = iter - 1)
      }
    }
    val result = loop(0, 1, n)
    println(result)
    result
  }

}

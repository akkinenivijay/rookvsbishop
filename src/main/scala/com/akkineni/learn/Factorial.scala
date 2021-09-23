package com.akkineni.learn

import scala.annotation.tailrec

object Factorial {
  def compute(n: Int): Double = {

    @tailrec
    def loop(index: Int, accum: Double): Double = {
      if (index == 1)
        accum
      else
        loop(index - 1, index * accum)
    }

    loop(n, 1.0)
  }

}

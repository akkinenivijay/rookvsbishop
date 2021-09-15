package com.akkineni.learn

import scala.annotation.tailrec

object Prime {

  def test(n: Int): Boolean = {

    @tailrec
    def loop(i: Int): Boolean = {

      if (i > Math.sqrt(n))
        true
      else if (n % i == 0)
        false
      else
        loop(i + 1)
    }
    loop(2)
  }
}

package com.zushealth

import org.scalatest.funsuite.AnyFunSuite
import scala.util.Random
import org.mockito.MockitoSugar.{mock, when}
import com.akkineni.Utils

class UtilsSuite extends AnyFunSuite {
  test("Generate 15 Moves all tails and 12 moves.") {
    val rand: Random = mock[Random]
    when(rand.nextInt(6)).thenReturn(5)
    when(rand.nextInt(2)).thenReturn(1)
    val moves = Utils(rand).generate15Moves()
    assert(
      moves sameElements Array(
        (Symbol("Tails"), 12),
        (Symbol("Tails"), 12),
        (Symbol("Tails"), 12),
        (Symbol("Tails"), 12),
        (Symbol("Tails"), 12),
        (Symbol("Tails"), 12),
        (Symbol("Tails"), 12),
        (Symbol("Tails"), 12),
        (Symbol("Tails"), 12),
        (Symbol("Tails"), 12),
        (Symbol("Tails"), 12),
        (Symbol("Tails"), 12),
        (Symbol("Tails"), 12),
        (Symbol("Tails"), 12),
        (Symbol("Tails"), 12)
      )
    )
  }

  test("Generate 15 Moves all heads and 12 moves.") {
    val rand: Random = mock[Random]
    when(rand.nextInt(6)).thenReturn(5)
    when(rand.nextInt(2)).thenReturn(0)
    val moves = Utils(rand).generate15Moves()
    assert(
      moves sameElements Array(
        (Symbol("Heads"), 12),
        (Symbol("Heads"), 12),
        (Symbol("Heads"), 12),
        (Symbol("Heads"), 12),
        (Symbol("Heads"), 12),
        (Symbol("Heads"), 12),
        (Symbol("Heads"), 12),
        (Symbol("Heads"), 12),
        (Symbol("Heads"), 12),
        (Symbol("Heads"), 12),
        (Symbol("Heads"), 12),
        (Symbol("Heads"), 12),
        (Symbol("Heads"), 12),
        (Symbol("Heads"), 12),
        (Symbol("Heads"), 12)
      )
    )
  }
}

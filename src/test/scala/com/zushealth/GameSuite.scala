package com.akkineni

import org.mockito.MockitoSugar.{mock, when}
import org.scalatest.funsuite.AnyFunSuite

class GameSuite extends AnyFunSuite {

  test("Bishop should capture after iteration 1 when heads") {
    val utils: Utils = mock[Utils]
    when(utils.generate15Moves()).thenReturn(
      Array(
        (Symbol("Heads"), 7),
        (Symbol("Tails"), 4),
        (Symbol("Tails"), 8),
        (Symbol("Heads"), 7),
        (Symbol("Tails"), 8),
        (Symbol("Heads"), 11),
        (Symbol("Heads"), 8),
        (Symbol("Heads"), 6),
        (Symbol("Heads"), 8),
        (Symbol("Heads"), 5),
        (Symbol("Heads"), 10),
        (Symbol("Heads"), 5),
        (Symbol("Heads"), 10),
        (Symbol("Tails"), 8),
        (Symbol("Tails"), 8)
      )
    )
    val game: Game = new Game(utils)
    val endResult: String = game.play()
    assert(endResult == "Bishop Captured Rook in iteration 1 !!")
  }

  test("Bishop should capture after iteration 1 when tails") {
    val utils: Utils = mock[Utils]
    when(utils.generate15Moves()).thenReturn(
      Array(
        (Symbol("Tails"), 1),
        (Symbol("Tails"), 4),
        (Symbol("Tails"), 8),
        (Symbol("Heads"), 7),
        (Symbol("Tails"), 8),
        (Symbol("Heads"), 11),
        (Symbol("Heads"), 8),
        (Symbol("Heads"), 6),
        (Symbol("Heads"), 8),
        (Symbol("Heads"), 5),
        (Symbol("Heads"), 10),
        (Symbol("Heads"), 5),
        (Symbol("Heads"), 10),
        (Symbol("Tails"), 8),
        (Symbol("Tails"), 8)
      )
    )
    val game: Game = new Game(utils)
    val endResult: String = game.play()
    assert(endResult == "Bishop Captured Rook in iteration 1 !!")
  }

  test("Rook should survive 15 rounds") {
    val utils: Utils = mock[Utils]
    when(utils.generate15Moves()).thenReturn(
      Array(
        (Symbol("Tails"), 7),
        (Symbol("Tails"), 7),
        (Symbol("Tails"), 12),
        (Symbol("Tails"), 8),
        (Symbol("Tails"), 10),
        (Symbol("Tails"), 7),
        (Symbol("Tails"), 5),
        (Symbol("Heads"), 8),
        (Symbol("Heads"), 6),
        (Symbol("Heads"), 10),
        (Symbol("Heads"), 9),
        (Symbol("Heads"), 11),
        (Symbol("Heads"), 6),
        (Symbol("Tails"), 9),
        (Symbol("Heads"), 11)
      )
    )
    val game: Game = new Game(utils)
    val endResult: String = game.play()
    assert(endResult == "Rook survived 15 rounds !!")
  }
}

package com.akkineni

import org.mockito.MockitoSugar.{mock, when}
import org.scalatest.funsuite.AnyFunSuite

class GameSuite extends AnyFunSuite {

  test("Bishop should capture after iteration 1 when heads") {

    val utils: Utils = mock[Utils]
    when(utils.tossAndRoll()).thenReturn((Symbol("Heads"), 7))
    val game: Game = new Game(utils)
    val endResult: String = game.play()

    assert(endResult == "Bishop Captured Rook in iteration 1 !!")
  }

  test("Bishop should capture after iteration 1 when tails") {

    val utils: Utils = mock[Utils]
    when(utils.tossAndRoll()).thenReturn((Symbol("Tails"), 1))
    val game: Game = new Game(utils)
    val endResult: String = game.play()

    assert(endResult == "Bishop Captured Rook in iteration 1 !!")
  }
}

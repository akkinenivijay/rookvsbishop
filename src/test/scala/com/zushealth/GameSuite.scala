package com.zushealth

import org.mockito.MockitoSugar.{mock, when}
import org.scalatest.funsuite.AnyFunSuite

class GameSuite extends AnyFunSuite {

  test("Game Play") {

    val utils: Utils = mock[Utils]
    when(utils.tossAndRoll()).thenReturn((Symbol("Heads"), 7))
    val game: Game = new Game(utils)
    val endResult: String = game.play()

    assert(endResult.contains("Bishop Captured Rook in iteration"))
  }
}

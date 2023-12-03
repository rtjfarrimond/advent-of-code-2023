package com.rtjfarrimond.aoc.challenges.day02

import munit.FunSuite

class GameTest extends FunSuite {

  test("parse should parse the Game") {
    val id = 4
    val input = s"Game $id: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red"
    val expectedTurns = List(
      Turn(blueCount = 6, redCount = 3, greenCount = 1),
      Turn(blueCount = 0, redCount = 6, greenCount = 3),
      Turn(blueCount = 15, redCount = 14, greenCount = 3),
    )

    val actual = Game.parse(input)
    assertEquals(actual.id, id)
    assertEquals(actual.turns, expectedTurns)
  }

}

package com.rtjfarrimond.aoc.challenges.day02

import munit.FunSuite

class TurnTest extends FunSuite {

  test("parse should parse a List of turns") {
    val input = "1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red"
    val expected = List(
      Turn(blueCount = 6, redCount = 3,greenCount = 1),
      Turn(blueCount = 0, redCount = 6,greenCount = 3),
      Turn(blueCount = 15, redCount = 14,greenCount = 3),
    )
    assertEquals(Turn.parse(input), expected)
  }

}

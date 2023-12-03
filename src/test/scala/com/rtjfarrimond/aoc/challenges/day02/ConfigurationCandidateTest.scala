package com.rtjfarrimond.aoc.challenges.day02

import munit.FunSuite

class ConfigurationCandidateTest extends FunSuite {

  test("ofGame should produce the configuration with the minimal possible configuration") {
    val turns = List(
      Turn(blueCount = 3, redCount = 4, greenCount = 0),
      Turn(blueCount = 6, redCount = 1, greenCount = 2),
      Turn(blueCount = 0, redCount = 0, greenCount = 2)
    )
    val game = Game(1, turns)
    val actual = ConfigurationCandidate.ofGame(game)

    val expected = ConfigurationCandidate(blueTotal = 6, redTotal = 4, greenTotal = 2)
    assertEquals(actual.power, 48)
  }

}

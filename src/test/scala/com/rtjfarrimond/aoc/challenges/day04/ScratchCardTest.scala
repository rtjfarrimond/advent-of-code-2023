package com.rtjfarrimond.aoc.challenges.day04

import munit.FunSuite

class ScratchCardTest extends FunSuite {

  test("parse should parse a scratchcard") {
    val input = "Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53"
    val expected = ScratchCard(
      id = 1,
      givenNumbers = Set(41, 48, 83, 86, 17),
      winningNumbers = Set(83, 86, 6, 31, 17, 9, 48, 53)
    )
    assertEquals(ScratchCard.parse(input), expected)
  }

  test("score should be a power of two given the size of the intersection") {
    val input = "Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53"
    val scratchCard = ScratchCard(
      id = 1,
      givenNumbers = Set(41, 48, 83, 86, 17),
      winningNumbers = Set(83, 86, 6, 31, 17, 9, 48, 53)
    )
    assertEquals(scratchCard.score, 8)
  }

}

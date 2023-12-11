package com.rtjfarrimond.aoc.challenges.day06

import munit.FunSuite

class Day06Test extends FunSuite {

  private val input = List(
    "Time:      7  15   30",
    "Distance:  9  40  200"
  )

  test("part 1") {
    val obtained = Day06.part1(input)
    val expected = 288L
    assertEquals(obtained, expected)
  }

}

package com.rtjfarrimond.aoc.challenges.day06

import munit.FunSuite

class Day06Test extends FunSuite {

  test("part 1") {
    val input = List(
      "Time:      7  15   30",
      "Distance:  9  40  200"
    )
    val obtained = Day06.part1(input)
    val expected = 288L
    assertEquals(obtained, expected)
  }

  test("part 2") {
    val input = List(
      "Time:      71530",
      "Distance:  940200"
    )
    val obtained = Day06.part2(input)
    val expected = 71503L
    assertEquals(obtained, expected)
  }

}

package com.rtjfarrimond.aoc.challenges.day02

import munit.FunSuite

class Day02Test extends FunSuite {

  private val input = List(
    "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green",
    "Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue",
    "Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red",
    "Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red",
    "Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green"
  )

  test("part1") {
    val obtained = Day02.part1(input)
    val expected = 8
    assertEquals(obtained, expected)
  }

  test("part2") {
    val obtained = Day02.part2(input)
    val expected = 2286
    assertEquals(obtained, expected)
  }

}

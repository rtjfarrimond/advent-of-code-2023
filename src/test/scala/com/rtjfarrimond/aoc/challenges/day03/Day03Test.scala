package com.rtjfarrimond.aoc.challenges.day03

import munit.FunSuite

class Day03Test extends FunSuite {

  test("part1") {
    val input = List(
      "467..114..",
      "...*......",
      "..35..633.",
      "......#...",
      "617*......",
      ".....+.58.",
      "..592.....",
      "......755.",
      "...$.*....",
      ".664.598.."
    )
    val actual = Day03.part1(input)
    val expected = 4361
    assertEquals(actual, expected)
  }

  test("part2".ignore) {
    val actual = Day03.part2(Nil)
    val expected = 123
    assertEquals(actual, expected)
  }

}

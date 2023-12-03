package com.rtjfarrimond.aoc.challenges

import munit.FunSuite

class Day01Test extends FunSuite {
  test("part1") {
    val input = List(
      "1abc2",
      "pqr3stu8vwx",
      "a1b2c3d4e5f",
      "treb7uchet"
    )
    val obtained = Day01.part1(input)
    val expected = 142
    assertEquals(obtained, expected)
  }

  test("part2") {
    val input = List(
      "two1nine",
      "eightwothree",
      "abcone2threexyz",
      "xtwone3four",
      "4nineeightseven2",
      "zoneight234",
      "7pqrstsixteen"
    )
    val obtained = Day01.part2(input)
    val expected = 281
    assertEquals(obtained, expected)
  }

  test("parseNumbers") {
    val input = List(
      "two1nine",
      "eightwothree",
      "abcone2threexyz",
      "xtwone3four",
      "4nineeightseven2",
      "zoneight234",
      "7pqrstsixteen"
    )
    val expected =  List(
      "219",
      "823",
      "123",
      "2134",
      "49872",
      "18234",
      "76"
    )
    val actual = input.map(Day01.parseNumbers)
    assertEquals(actual, expected)
  }

  test("parseNumbers should parse even when numbers overlap") {
    val input = "nineightwone"
    val expected = "9821"
    val actual = Day01.parseNumbers(input)
    assertEquals(actual, expected)
  }

}

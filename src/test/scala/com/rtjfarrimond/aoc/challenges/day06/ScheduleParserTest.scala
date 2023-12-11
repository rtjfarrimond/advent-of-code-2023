package com.rtjfarrimond.aoc.challenges.day06

import munit.FunSuite

class ScheduleParserTest extends FunSuite {

  private val input = List(
    "Time:      7  15   30",
    "Distance:  9  40  200"
  )

  test("Part 1 - parse should parse a Schedule") {
    val obtained = ScheduleParserPart1.parse(input)
    val expected = Schedule(List(
      Race(timeAllowed = 7, recordDistance = 9),
      Race(timeAllowed = 15, recordDistance = 40),
      Race(timeAllowed = 30, recordDistance = 200)
    ))

    assertEquals(obtained, expected)
  }

  test("Part 2 - parse should parse a Schedule") {
    val obtained = ScheduleParserPart2.parse(input)
    val expected = Schedule(List(
      Race(timeAllowed = 71530, recordDistance = 940200)
    ))

    assertEquals(obtained, expected)
  }

}

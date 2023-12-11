package com.rtjfarrimond.aoc.challenges.day06

import munit.FunSuite

class ScheduleTest extends FunSuite {

  test("parse should parse a Schedule") {
    val input = List(
      "Time:      7  15   30",
      "Distance:  9  40  200"
    )
    val obtained = Schedule.parse(input)
    val expected = Schedule(List(
      Race(timeAllowed = 7, recordDistance = 9),
      Race(timeAllowed = 15, recordDistance = 40),
      Race(timeAllowed = 30, recordDistance = 200)
    ))

    assertEquals(obtained, expected)
  }

}

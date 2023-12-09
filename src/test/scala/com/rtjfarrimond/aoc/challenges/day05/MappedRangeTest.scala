package com.rtjfarrimond.aoc.challenges.day05

import munit.FunSuite

class MappedRangeTest extends FunSuite {

  test("parse should construct a Range") {
    val input = "50 98 2 "
    val obtained = MappedRange.parse(input)
    val expected = MappedRange(98, 50, 2)
    assertEquals(obtained, expected)
  }

}

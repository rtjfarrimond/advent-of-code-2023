package com.rtjfarrimond.aoc.challenges.day05

import munit.FunSuite

class MappedRangeTest extends FunSuite {

  test("parse should construct a Range") {
    val input = "50 98 2 "
    val obtained = MappedRange.parse(input)
    val expected = MappedRange(98, 50, 2)
    assertEquals(obtained, expected)
  }

  test("contains should be true for a value between start and end") {
    val mappedRange = MappedRange(sourceStart = 98, destinationStart = 50, length = 10)
    assert(mappedRange.contains(99))
  }

}

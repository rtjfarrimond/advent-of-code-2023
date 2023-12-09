package com.rtjfarrimond.aoc.challenges.day05

import munit.FunSuite

class GardenMapTest extends FunSuite {

  test("getDestination should provide the mapped value if it exists or return the given source") {
    val input = List(
      MappedRange(sourceStart = 98, destinationStart = 50, length = 2),
      MappedRange(sourceStart = 50, destinationStart = 52, length = 48)
    )
    val map = GardenMap(input)

    assertEquals(map.getDestination(98L), 50L)
    assertEquals(map.getDestination(99L), 51L)

    assertEquals(map.getDestination(50L), 52L)
    assertEquals(map.getDestination(97L), 99L)

    assertEquals(map.getDestination(49L), 49L)
    assertEquals(map.getDestination(100L), 100L)
  }

}

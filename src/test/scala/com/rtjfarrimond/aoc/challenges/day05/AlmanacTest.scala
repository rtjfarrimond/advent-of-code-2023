package com.rtjfarrimond.aoc.challenges.day05

import munit.FunSuite

class AlmanacTest extends FunSuite {

  private val inputString =
    """
      |seeds: 79 14 55 13
      |
      |seed-to-soil map:
      |50 98 2
      |52 50 48
      |
      |soil-to-fertilizer map:
      |0 15 37
      |37 52 2
      |39 0 15
      |
      |fertilizer-to-water map:
      |49 53 8
      |0 11 42
      |42 0 7
      |57 7 4
      |
      |water-to-light map:
      |88 18 7
      |18 25 70
      |
      |light-to-temperature map:
      |45 77 23
      |81 45 19
      |68 64 13
      |
      |temperature-to-humidity map:
      |0 69 1
      |1 0 69
      |
      |humidity-to-location map:
      |60 56 37
      |56 93 4
      |""".stripMargin

  test("parse") {
    val input = inputString.split('\n').toList.tail
    val obtained = Almanac.parse(input)
    val expected = Almanac(
      seeds = List(79, 14, 55, 13),
      seedsToSoil = GardenMap(List(
        MappedRange.parse("50 98 2"),
        MappedRange.parse("52 50 48"),
      )),
      soilToFertilizer = GardenMap(List(
        MappedRange.parse("0 15 37"),
        MappedRange.parse("37 52 2"),
        MappedRange.parse("39 0 15"),
      )),
      fertilizerToWater = GardenMap(List(
        MappedRange.parse("49 53 8"),
        MappedRange.parse("0 11 42"),
        MappedRange.parse("42 0 7"),
        MappedRange.parse("57 7 4"),
      )),
      waterToLight = GardenMap(List(
        MappedRange.parse("88 18 7"),
        MappedRange.parse("18 25 70"),
      )),
      lightToTemperature = GardenMap(List(
        MappedRange.parse("45 77 23"),
        MappedRange.parse("81 45 19"),
        MappedRange.parse("68 64 13"),
      )),
      temperatureToHumidity = GardenMap(List(
        MappedRange.parse("0 69 1"),
        MappedRange.parse("1 0 69"),
      )),
      humidityToLocation = GardenMap(List(
        MappedRange.parse("60 56 37"),
        MappedRange.parse("56 93 4"),
      ))
    )
    assertEquals(obtained, expected)
  }


}

package com.rtjfarrimond.aoc.challenges.day05

case class Almanac(
  seeds: List[Long],
  seedsToSoil: GardenMap,
  soilToFertilizer: GardenMap,
  fertilizerToWater: GardenMap,
  waterToLight: GardenMap,
  lightToTemperature: GardenMap,
  temperatureToHumidity: GardenMap,
  humidityToLocation: GardenMap,
) {
  val seedLocations: List[Long] = seeds.map { seed =>
    seedsToSoil.getDestination
      .andThen(soilToFertilizer.getDestination)
      .andThen(fertilizerToWater.getDestination)
      .andThen(waterToLight.getDestination)
      .andThen(lightToTemperature.getDestination)
      .andThen(temperatureToHumidity.getDestination)
      .andThen(humidityToLocation.getDestination)(seed)
  }
}

object Almanac {

  def parse(input: List[String]): Almanac = {
    val seeds = input.head.dropWhile(_ != ':').tail.trim.split(' ').map(_.trim.toLong)
    Almanac(
      seeds = seeds.toList,
      seedsToSoil = extractGardenMap(input, "seed-to-soil map:"),
      soilToFertilizer = extractGardenMap(input, "soil-to-fertilizer map:"),
      fertilizerToWater = extractGardenMap(input, "fertilizer-to-water map:"),
      waterToLight = extractGardenMap(input, "water-to-light map:"),
      lightToTemperature = extractGardenMap(input, "light-to-temperature map:"),
      temperatureToHumidity = extractGardenMap(input, "temperature-to-humidity map:"),
      humidityToLocation = extractGardenMap(input, "humidity-to-location map:")
    )
  }

  private def extractGardenMap(input: List[String], identifier: String): GardenMap =
    GardenMap(input.dropWhile(_ != identifier).tail.takeWhile(_.nonEmpty).map(MappedRange.parse))

}

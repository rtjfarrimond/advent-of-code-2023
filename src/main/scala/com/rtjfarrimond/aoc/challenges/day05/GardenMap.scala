package com.rtjfarrimond.aoc.challenges.day05

case class GardenMap(ranges: List[MappedRange]):
  def getDestination(source: Long): Long =
    ranges.find(_.contains(source)).map { mappedRange =>
      val diff = mappedRange.destinationStart - mappedRange.sourceStart
      source + diff
    }.getOrElse(source)

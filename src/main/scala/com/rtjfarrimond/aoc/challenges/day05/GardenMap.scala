package com.rtjfarrimond.aoc.challenges.day05

trait GardenMap:
  def getDestination(source: Long): Long

object GardenMap {

  private case class GardenMapImpl(ranges: Set[MappedRange]) extends GardenMap:
    override def getDestination(source: Long): Long =
      ranges.find(_.contains(source)).map { mappedRange =>
        val diff = mappedRange.destinationStart - mappedRange.sourceStart
        source + diff
      }.getOrElse(source)

  def apply(mappedRanges: List[MappedRange]): GardenMap =
    GardenMapImpl(mappedRanges.toSet)

}

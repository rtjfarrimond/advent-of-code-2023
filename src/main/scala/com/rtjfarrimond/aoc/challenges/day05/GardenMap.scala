package com.rtjfarrimond.aoc.challenges.day05

import scala.collection.immutable.NumericRange

trait GardenMap:
  def getDestination(source: Long): Long

object GardenMap {

  private case class GardenMapImpl(lookup: Map[Long, Long]) extends GardenMap {
    override def getDestination(source: Long): Long =
      lookup.getOrElse(source, source)
  }

  def apply(mappedRanges: List[MappedRange]): GardenMap = {
    val lookup = mappedRanges.map { mappedRange =>
        val sources = computeRange(mappedRange.sourceStart, mappedRange.length)
        val destinations = computeRange(mappedRange.destinationStart, mappedRange.length)
        sources.zip(destinations).toMap
      }
      .foldLeft(Map.empty[Long, Long])(_ ++ _)
    GardenMapImpl(lookup)
  }

  private def computeRange(start: Long, length: Long): NumericRange.Exclusive[Long] = {
    val end = start + length
    start until end
  }

}

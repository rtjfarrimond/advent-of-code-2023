package com.rtjfarrimond.aoc.challenges.day05

case class MappedRange(sourceStart: Long, destinationStart: Long, length: Long):
  def contains(value: Long): Boolean =
    sourceStart <= value && value < (sourceStart + length)

object MappedRange {

  def parse(input: String): MappedRange = {
    val parts = input.split(' ').map(_.trim.toLong)
    MappedRange(parts(1), parts(0), parts(2))
  }

}

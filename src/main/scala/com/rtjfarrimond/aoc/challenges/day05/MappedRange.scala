package com.rtjfarrimond.aoc.challenges.day05

case class MappedRange(sourceStart: Long, destinationStart: Long, length: Long)

object MappedRange {

  def parse(input: String): MappedRange = {
    val parts = input.split(' ').map(_.trim.toLong)
    MappedRange(parts(1), parts(0), parts(2))
  }

}

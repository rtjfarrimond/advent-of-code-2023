package com.rtjfarrimond.aoc.challenges.day05

import com.rtjfarrimond.aoc.Challenge

object Day05 extends Challenge(5) {
  override def part1(input: List[String]): Long =
    Almanac.parse(input).seedLocations.min

  override def part2(input: List[String]): Long = 42
}

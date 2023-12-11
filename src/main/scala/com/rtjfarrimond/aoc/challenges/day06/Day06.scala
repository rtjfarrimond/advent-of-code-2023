package com.rtjfarrimond.aoc.challenges.day06

import com.rtjfarrimond.aoc.Challenge

object Day06 extends Challenge(6) {
  override def part1(input: List[String]): Long =
    val schedule = Schedule.parse(input)
    schedule.races.map(RacePlanner.plan).map(_.size).product

  override def part2(input: List[String]): Long = 42
}

package com.rtjfarrimond.aoc.challenges.day06

import com.rtjfarrimond.aoc.Challenge

object Day06 extends Challenge(6) {
  override def part1(input: List[String]): Long =
    common(input, ScheduleParserPart1)

  override def part2(input: List[String]): Long =
    common(input, ScheduleParserPart2)

  private def common(input: List[String], scheduleParser: ScheduleParser): Long =
    val schedule = scheduleParser.parse(input)
    schedule.races.map(RacePlanner.plan).product
}

package com.rtjfarrimond.aoc.challenges.day06

trait ScheduleParser:
  def parse(input: List[String]): Schedule

object ScheduleParserPart1 extends ScheduleParser:
  override def parse(input: List[String]): Schedule =
    val ints = input.map { string =>
      string.dropWhile(_ != ':').tail.trim.split(' ').filterNot(_.isEmpty).map(_.toLong)
    }
    val races = ints(0).zip(ints(1)).map(Race.apply).toList
    Schedule(races)

object ScheduleParserPart2 extends ScheduleParser:
  override def parse(input: List[String]): Schedule =
    val ints = input.map { string =>
      string.dropWhile(_ != ':').tail.trim.filterNot(_ == ' ').toLong
    }
    val races = List(Race(ints(0), ints(1)))
    Schedule(races)

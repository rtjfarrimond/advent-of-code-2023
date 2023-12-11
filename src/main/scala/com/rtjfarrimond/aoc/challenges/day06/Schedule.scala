package com.rtjfarrimond.aoc.challenges.day06

case class Race(timeAllowed: Int, recordDistance: Int)
case class Schedule(races: List[Race])

object Schedule:
  def parse(input: List[String]): Schedule =
    val ints = input.map { string =>
      string.dropWhile(_ != ':').tail.trim.split(' ').filterNot(_.isEmpty).map(_.toInt)
    }
    val races = ints(0).zip(ints(1)).map(Race.apply).toList
    Schedule(races)

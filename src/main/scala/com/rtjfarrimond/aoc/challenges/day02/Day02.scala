package com.rtjfarrimond.aoc.challenges.day02

import com.rtjfarrimond.aoc.Challenge

object Day02 extends Challenge(2) {


  override def part1(input: List[String]): Int = {
    val games = input.map(Game.parse)
    val configCandidate = ConfigurationCandidate(blueTotal = 14, redTotal = 12, greenTotal = 13)
    val possibleGameIds = games.filter(_.isPossible(configCandidate)).map(_.id)
    possibleGameIds.sum
  }

  override def part2(input: List[String]): Int = {
    val games = input.map(Game.parse)
    val configs = games.map(ConfigurationCandidate.ofGame)
    configs.map(_.power).sum
  }
}

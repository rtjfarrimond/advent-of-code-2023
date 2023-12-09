package com.rtjfarrimond.aoc.challenges.day04

import com.rtjfarrimond.aoc.Challenge

object Day04 extends Challenge(4) {
  override def part1(input: List[String]): Int =
    input.map(ScratchCard.parse.andThen(_.score)).sum

  override def part2(input: List[String]): Int =
    CardScratcher.scratchCards(input.map(ScratchCard.parse))
}

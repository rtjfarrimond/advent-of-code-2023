package com.rtjfarrimond.aoc.challenges.day04

case class ScratchCard(id: Int, givenNumbers: Set[Int], winningNumbers: Set[Int]) {
  val intersection: Set[Int] = givenNumbers.intersect(winningNumbers)
  val score: Int = scala.math.pow(2, intersection.size - 1).toInt
}

object ScratchCard {

  def parse(input: String): ScratchCard = {
    val id = input.takeWhile(_ != ':').split(' ').map(_.trim).last.toInt
    val givenNumberString = input.dropWhile(_ != ':').tail.takeWhile(_ != '|')
    val givenNumbers = parseInts(givenNumberString)
    val winningNumberString = input.dropWhile(_ != '|').tail
    val winningNumbers = parseInts(winningNumberString)
    ScratchCard(id, givenNumbers.toSet, winningNumbers.toSet)
  }

  private def parseInts(s: String) =
    s.split(' ')
      .collect {
        case string if !string.isBlank =>
          string.toInt
      }

}

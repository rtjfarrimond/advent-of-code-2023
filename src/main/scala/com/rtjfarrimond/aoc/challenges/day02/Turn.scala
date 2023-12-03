package com.rtjfarrimond.aoc.challenges.day02

case class Turn(blueCount: Int, redCount: Int, greenCount: Int)

object Turn {
  val empty: Turn = Turn(blueCount = 0, redCount = 0, greenCount = 0)

  def parse(input: String): List[Turn] =
    val stringTurns = input.split("; ").map(_.trim).toList
    stringTurns.map(parseOne)

  private def parseOne(input: String): Turn =
    input.split(", ").foldLeft(empty) { (acc, next) =>
      val split = next.split(' ')
      val count = split.head.toInt
      val colour = split.last

      colour match
        case "blue" => acc.copy(blueCount = acc.blueCount + count)
        case "red" => acc.copy(redCount = acc.redCount + count)
        case "green" => acc.copy(greenCount = acc.greenCount + count)
        case _ => throw new RuntimeException("Advent of code input malformed, should never happen")
    }
}

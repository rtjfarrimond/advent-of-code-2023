package com.rtjfarrimond.aoc.challenges

import com.rtjfarrimond.aoc.Challenge

import scala.annotation.tailrec

object Day01 extends Challenge(1) {

  private val numberChars = '0' to '9'

  override def part1(input: List[String]): Int =
    lineToInt(input).sum

  override def part2(input: List[String]): Int =
    lineToInt(input.map(parseNumbers)).sum

  private def lineToInt(input: List[String]): List[Int] =
    input.map { str =>
      val filtered = str.filter(numberChars.contains)
      s"${filtered.head}${filtered.last}".toInt
    }

  def parseNumbers(input: String): String = {
    val numberNames = Map(
      "zero" -> 0,
      "one" -> 1,
      "two" -> 2,
      "three" -> 3,
      "four" -> 4,
      "five" -> 5,
      "six" -> 6,
      "seven" -> 7,
      "eight" -> 8,
      "nine" -> 9
    )

    @tailrec
    def loop(left: String, right: String): String =
      right.headOption match
        case None => left
        case Some(next) =>
          val maybeNumberMapping = numberNames.find { case (numberName, _) =>
            right.startsWith(numberName)
          }
          val nextLeft = maybeNumberMapping match
            case Some((_, number)) => s"$left$number"
            case None => s"$left$next"
          loop(nextLeft, right.tail)

    loop("", input).filter(numberChars.contains)
  }

}

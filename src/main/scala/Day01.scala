import scala.annotation.tailrec

@main def run(): Unit =
  val input = InputLoader.load("day01.txt").toList
  println(s"Part1: ${Day01.part1(input)}")
  println(s"Part2: ${Day01.part2(input)}")

object Day01 {

  private val numberChars = '0' to '9'

  def part1(input: List[String]): Int =
    lineToInt(input).sum

  def part2(input: List[String]): Int =
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

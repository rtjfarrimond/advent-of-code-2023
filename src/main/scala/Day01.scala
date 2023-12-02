@main def run(): Unit =
  println(s"Part1: ${Day01.part1()}")

object Day01 {

  private val input = InputLoader.load("day01.txt")

  def part1(): Int = {
    val numberChars = ('0' to '9').toSet
    val ints: List[Int] = input.map { str =>
      val filtered = str.filter(numberChars.contains)
      s"${filtered.head}${filtered.last}".toInt
    }.toList

    ints.sum
  }

}

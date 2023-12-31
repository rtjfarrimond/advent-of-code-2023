import com.rtjfarrimond.aoc.Challenge
import com.rtjfarrimond.aoc.challenges.*
import com.rtjfarrimond.aoc.challenges.day02.Day02
import com.rtjfarrimond.aoc.challenges.day03.Day03
import com.rtjfarrimond.aoc.challenges.day04.Day04
import com.rtjfarrimond.aoc.challenges.day05.Day05
import com.rtjfarrimond.aoc.challenges.day06.Day06

@main def run(dayNumber: Int): Unit =
  // TODO: Automate updates to this set
  val allChallenges: Set[Challenge] = Set(
    Day01,
    Day02,
    Day03,
    Day04,
    Day05,
    Day06
  )
  allChallenges.find(_.dayNumber == dayNumber) match
    case Some(challenge) =>
      challenge.run()
    case None =>
      println(s"com.rtjfarrimond.aoc.Challenge number $dayNumber was not found!")

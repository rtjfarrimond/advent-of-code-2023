import com.rtjfarrimond.aoc.Challenge
import com.rtjfarrimond.aoc.challenges.Day01

@main def run(dayNumber: Int): Unit =
  val allChallenges: Set[Challenge] = Set(
    Day01
  )
  allChallenges.find(_.dayNumber == dayNumber) match
    case Some(challenge) =>
      challenge.run()
    case None =>
      println(s"com.rtjfarrimond.aoc.Challenge number $dayNumber was not found!")

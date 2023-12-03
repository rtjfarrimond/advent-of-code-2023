package com.rtjfarrimond.aoc.challenges.day02

case class ConfigurationCandidate(blueTotal: Int, redTotal: Int, greenTotal: Int) {
  val power: Int = blueTotal * greenTotal * redTotal
}

object ConfigurationCandidate {

  def ofGame(game: Game): ConfigurationCandidate =
    game.turns.foldLeft(ConfigurationCandidate(0, 0, 0)) { (candidate, turn) =>
      val minimalBlue = scala.math.max(candidate.blueTotal, turn.blueCount)
      val minimalRed = scala.math.max(candidate.redTotal, turn.redCount)
      val minimalGreen = scala.math.max(candidate.greenTotal, turn.greenCount)
      ConfigurationCandidate(blueTotal = minimalBlue, redTotal = minimalRed, greenTotal = minimalGreen)
    }

}

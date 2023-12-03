package com.rtjfarrimond.aoc.challenges.day02

import jdk.jfr.Configuration

case class Game(id: Int, turns: List[Turn])

object Game {

  def parse(input: String): Game = {
    val id = input.dropWhile(_ != ' ').trim.takeWhile(_ != ':').toInt
    val turnsString = input.dropWhile(_ != ':').tail.trim
    Game(id, Turn.parse(turnsString))
  }

  extension (game: Game)
    def isPossible(givenConfiguration: ConfigurationCandidate): Boolean =
      game.turns.forall { turn =>
        givenConfiguration.blueTotal >= turn.blueCount &&
          givenConfiguration.redTotal >= turn.redCount &&
          givenConfiguration.greenTotal >= turn.greenCount
      }

}

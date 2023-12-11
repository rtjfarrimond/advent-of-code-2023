package com.rtjfarrimond.aoc.challenges.day06

import scala.annotation.tailrec

object RacePlanner {

  def plan(race: Race): Long = {

    @tailrec
    def loop(race: Race, remainingTime: Long, speed: Long = 0, acc: Long = 0): Long = {
      if (remainingTime == 0) acc
      else
        val distance = speed * remainingTime
        if (distance > race.recordDistance)
          loop(race, remainingTime - 1, speed + 1, acc + 1)
        else
          loop(race, remainingTime - 1, speed + 1, acc)
    }

    loop(race, race.timeAllowed)
  }

}

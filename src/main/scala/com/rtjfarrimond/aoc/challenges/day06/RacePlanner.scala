package com.rtjfarrimond.aoc.challenges.day06

import scala.annotation.tailrec

object RacePlanner {

  def plan(race: Race): Set[Long] = {

    @tailrec
    def loop(race: Race, remainingTime: Int, speed: Int = 0, acc: Set[Long] = Set.empty): Set[Long] = {
      if (remainingTime == 0) acc
      else
        val distance = speed * remainingTime
        if (distance > race.recordDistance)
          loop(race, remainingTime - 1, speed + 1, acc.incl(speed))
        else
          loop(race, remainingTime - 1, speed + 1, acc)
    }

    loop(race, race.timeAllowed)
  }

}

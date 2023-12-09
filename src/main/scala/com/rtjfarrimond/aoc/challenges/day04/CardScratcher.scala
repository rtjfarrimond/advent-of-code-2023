package com.rtjfarrimond.aoc.challenges.day04

import scala.annotation.tailrec

object CardScratcher {

  def scratchCards(cards: List[ScratchCard]): Map[Int, Int] = {

    var iterations = 0

    @tailrec
    def loop(scratchQueue: List[ScratchCard], counter: Map[Int, Int] = Map.empty): Map[Int, Int] = {
      iterations += 1
      if (iterations % 1000 == 0) {
        println(s"Iteration $iterations:")
        println(s"Queue has ${scratchQueue.length} elements")
        println(s"Scratched ${counter.values.sum} cards so far")
      }
      scratchQueue.headOption match
        case None => counter
        case Some(currentCard) =>
          val wonCardIds = (1 to currentCard.intersection.size).map(currentCard.id + _)
          val wonCards = cards.filter(card => wonCardIds.contains(card.id))
          val updatedQueue = scratchQueue.tail ++ wonCards
          val updatedCounter = counter.updated(currentCard.id, counter.getOrElse(currentCard.id, 0) + 1)
          if (iterations == 100000) throw new RuntimeException("Too many iterations")
          else loop(updatedQueue, updatedCounter)
    }

    loop(cards)
  }

}

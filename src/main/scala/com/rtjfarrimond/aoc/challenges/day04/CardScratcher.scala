package com.rtjfarrimond.aoc.challenges.day04

import scala.annotation.tailrec

object CardScratcher {

  def scratchCards(cards: List[ScratchCard]): Int = {

    @tailrec
    def loop(scratchQueue: List[ScratchCard], counter: Int = 0): Int = {
      if (counter % 1000 == 0) {
        println(s"Scratched $counter cards so far")
      }
      scratchQueue.headOption match
        case None => counter
        case Some(currentCard) =>
          val wonCardIds = (1 to currentCard.intersection.size).map(currentCard.id + _)
          val wonCards = cards.filter(card => wonCardIds.contains(card.id))
          val updatedQueue = scratchQueue.tail.prependedAll(wonCards)
          loop(updatedQueue, counter + 1)
    }

    loop(cards)
  }

}

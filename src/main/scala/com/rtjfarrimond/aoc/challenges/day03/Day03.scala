package com.rtjfarrimond.aoc.challenges.day03

import com.rtjfarrimond.aoc.Challenge
import com.rtjfarrimond.aoc.grid.Grid

object Day03 extends Challenge(3) {
  override def part1(input: List[String]): Int = {
    val schematics = input.map(_.toCharArray.toList.map(SchematicTile.apply))
    val grid = Grid(schematics)
    val partNumberFinder = new PartNumberFinder(grid)
    partNumberFinder.partNumbers.sum
  }

  override def part2(input: List[String]): Int = 42
}

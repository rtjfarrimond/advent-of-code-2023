package com.rtjfarrimond.aoc.challenges.day03

import com.rtjfarrimond.aoc.grid.Grid
import munit.FunSuite

class PartNumberFinderTest extends FunSuite {

  test("partNumbers should return numbers symbol adjacent") {
    val input = List(
      "467..114..",
      "...*......",
      "..35..633.",
      "......#...",
      "617*......",
      ".....+.58.",
      "..592.....",
      "......755.",
      "...$.*....",
      ".664.598.."
    )
    val schematics = input.map(_.toCharArray.toList.map(SchematicTile.apply))
    val grid = Grid(schematics)

    val actual = new PartNumberFinder(grid).partNumbers.sorted
    val expected = List(467, 35, 633, 617, 592, 755, 664, 598).sorted
    assertEquals(actual, expected)
  }

}

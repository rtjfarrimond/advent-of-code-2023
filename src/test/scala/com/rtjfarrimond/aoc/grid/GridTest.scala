package com.rtjfarrimond.aoc.grid

import com.rtjfarrimond.aoc.grid.Grid._
import munit.FunSuite

class GridTest extends FunSuite {

  private val grid = Grid[Int] {
    List(
      List(1, 2, 3),
      List(4, 5, 6),
      List(7, 8, 9),
    )
  }

  test("get should return None for the empty grid") {
    val grid = Grid[Int](Nil)
    assertEquals(grid.get(0, 0), None)
  }

  test("get should return Some for the singleton grid") {
    val answer = 42
    val grid = Grid[Int](List(List(answer)))
    val coord = Coordinate(0, 0)
    assertEquals(grid.get(coord), Some(Cell(coord, answer)))
  }

  test("adjacent should return the empty set") {
    val grid = Grid[Int](Nil)
    assertEquals(grid.adjacent(1, 1), Set.empty)
  }

  test("adjacent should return all 8 adjacent values") {
    val expected = Set(
      Grid.Cell(Coordinate(x = 0, y = 0), value = 1),
      Grid.Cell(Coordinate(x = 1, y = 0), value = 2),
      Grid.Cell(Coordinate(x = 2, y = 0), value = 3),
      Grid.Cell(Coordinate(x = 0, y = 1), value = 4),
      Grid.Cell(Coordinate(x = 2, y = 1), value = 6),
      Grid.Cell(Coordinate(x = 0, y = 2), value = 7),
      Grid.Cell(Coordinate(x = 1, y = 2), value = 8),
      Grid.Cell(Coordinate(x = 2, y = 2), value = 9)
    )
    val actual = grid.adjacent(1, 1)
    assertEquals(actual.size, 8)
    assertEquals(actual, expected)
  }

  test("adjacent return 5 adjacent values when given coordinate on top row") {

    val expected = Set(
      Grid.Cell(Coordinate(x = 0, y = 0), value = 1),
      Grid.Cell(Coordinate(x = 2, y = 0), value = 3),
      Grid.Cell(Coordinate(x = 0, y = 1), value = 4),
      Grid.Cell(Coordinate(x = 1, y = 1), value = 5),
      Grid.Cell(Coordinate(x = 2, y = 1), value = 6),
    )
    val actual = grid.adjacent(x = 1, y = 0)
    assertEquals(actual.size, 5)
    assertEquals(actual, expected)
  }

  test("adjacent return 5 adjacent values when given coordinate on bottom row") {
    val expected = Set(
      Grid.Cell(Coordinate(x = 0, y = 1), value = 4),
      Grid.Cell(Coordinate(x = 1, y = 1), value = 5),
      Grid.Cell(Coordinate(x = 2, y = 1), value = 6),
      Grid.Cell(Coordinate(x = 0, y = 2), value = 7),
      Grid.Cell(Coordinate(x = 2, y = 2), value = 9)
    )
    val actual = grid.adjacent(x = 1, y = 2)
    assertEquals(actual.size, 5)
    assertEquals(actual, expected)
  }

  test("adjacent return 5 adjacent values when given coordinate on leftmost column") {
    val expected = Set(
      Grid.Cell(Coordinate(x = 0, y = 0), value = 1),
      Grid.Cell(Coordinate(x = 1, y = 0), value = 2),
      Grid.Cell(Coordinate(x = 1, y = 1), value = 5),
      Grid.Cell(Coordinate(x = 0, y = 2), value = 7),
      Grid.Cell(Coordinate(x = 1, y = 2), value = 8),
    )
    val actual = grid.adjacent(x = 0, y = 1)
    assertEquals(actual.size, 5)
    assertEquals(actual, expected)
  }

  test("adjacent return 5 adjacent values when given coordinate on rightmost column") {
    val expected = Set(
      Grid.Cell(Coordinate(x = 1, y = 0), value = 2),
      Grid.Cell(Coordinate(x = 2, y = 0), value = 3),
      Grid.Cell(Coordinate(x = 1, y = 1), value = 5),
      Grid.Cell(Coordinate(x = 1, y = 2), value = 8),
      Grid.Cell(Coordinate(x = 2, y = 2), value = 9)
    )
    val actual = grid.adjacent(x = 2, y = 1)
    assertEquals(actual.size, 5)
    assertEquals(actual, expected)
  }

  test("adjacent return 3 adjacent values when given the top-left coordinate") {
    val expected = Set(
      Grid.Cell(Coordinate(x = 1, y = 0), value = 2),
      Grid.Cell(Coordinate(x = 0, y = 1), value = 4),
      Grid.Cell(Coordinate(x = 1, y = 1), value = 5),
    )
    val actual = grid.adjacent(0 ,0)
    assertEquals(actual.size, 3)
    assertEquals(actual, expected)
  }

  test("adjacent return 3 adjacent values when given the top-right coordinate") {
    val expected = Set(
      Grid.Cell(Coordinate(x = 1, y = 0), value = 2),
      Grid.Cell(Coordinate(x = 1, y = 1), value = 5),
      Grid.Cell(Coordinate(x = 2, y = 1), value = 6),
    )
    val actual = grid.adjacent(x = 2, y = 0)
    assertEquals(actual.size, 3)
    assertEquals(actual, expected)
  }

  test("adjacent return 3 adjacent values when given the bottom-left coordinate") {
    val expected = Set(
      Grid.Cell(Coordinate(x = 0, y = 1), value = 4),
      Grid.Cell(Coordinate(x = 1, y = 1), value = 5),
      Grid.Cell(Coordinate(x = 1, y = 2), value = 8),
    )
    val actual = grid.adjacent(x = 0, y = 2)
    assertEquals(actual.size, 3)
    assertEquals(actual, expected)
  }

  test("adjacent return 3 adjacent values when given the bottom-right coordinate") {
    val expected = Set(
      Grid.Cell(Coordinate(x = 1, y = 1), value = 5),
      Grid.Cell(Coordinate(x = 2, y = 1), value = 6),
      Grid.Cell(Coordinate(x = 1, y = 2), value = 8),
    )
    val actual = grid.adjacent(x = 2, y = 2)
    assertEquals(actual.size, 3)
    assertEquals(actual, expected)
  }

}

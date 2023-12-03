package com.rtjfarrimond.aoc.grid

import com.rtjfarrimond.aoc.grid.Grid._

import scala.util.Try

trait Grid[A] {
  def get(x: Int, y: Int): Option[Cell[A]]

  final def get(coordinate: Coordinate): Option[Cell[A]] =
    get(coordinate.x, coordinate.y)

  def adjacent(x: Int, y: Int): Set[Cell[A]]

  final def adjacent(coordinate: Coordinate): Set[Cell[A]] =
    adjacent(coordinate.x, coordinate.y)

  def values: List[Cell[A]]
}

object Grid {

  case class Coordinate(x: Int, y: Int)

  case class Cell[A](coordinate: Coordinate, value: A)

  def apply[A](input: List[List[A]]): Grid[A] = {
    val rowLengths = input.map(_.length).toSet
    if (rowLengths.size != 1)
      throw new RuntimeException(s"All rows in the grid must be of the same length. Expected for advent of code input. Observed row length set: ${rowLengths}")
    else
      new GridImpl[A](input)
  }

  private class GridImpl[A](input: List[List[A]]) extends Grid[A] {
    override def get(x: Int, y: Int): Option[Cell[A]] =
      Try(input(y)(x)).toOption.map(a => Cell(Coordinate(x, y), a))

    override def adjacent(x: Int, y: Int): Set[Cell[A]] =
      Set(
        get(x - 1, y),
        get(x + 1, y),
        get(x, y + 1),
        get(x, y - 1),
        get(x - 1, y - 1),
        get(x - 1, y + 1),
        get(x + 1, y - 1),
        get(x + 1, y + 1),
      ).flatten

    override def values: List[Cell[A]] = input.zipWithIndex.flatMap { (row, yCoord) =>
      row.zipWithIndex.map { (a, xCoord) =>
        Cell(Coordinate(x = xCoord, y = yCoord), a)
      }
    }
  }
}

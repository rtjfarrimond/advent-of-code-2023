package com.rtjfarrimond.aoc.challenges.day03

sealed trait SchematicTile {
  def isSymbolic: Boolean
}

object SchematicTile {
  case object Empty extends SchematicTile {
    override val isSymbolic: Boolean = false
  }

  case class NumericChar(value: Char) extends SchematicTile {
    override val isSymbolic: Boolean = false
  }

  case class Symbolic(value: Char) extends SchematicTile {
    override val isSymbolic: Boolean = true
  }

  def apply(char: Char): SchematicTile =
    char match
      case '.' => Empty
      case a if ('0' to '9').contains(a) => NumericChar(a)
      case a => Symbolic(a)

}


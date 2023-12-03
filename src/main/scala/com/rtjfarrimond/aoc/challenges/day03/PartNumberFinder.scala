package com.rtjfarrimond.aoc.challenges.day03

import com.rtjfarrimond.aoc.grid.Grid

class PartNumberFinder(grid: Grid[SchematicTile]) {

  private case class State(partNumbers: List[Int], buffer: String, symbolAdjacent: Boolean)

  extension (state: State)
    private def flushBuffer(currentlyAdjacent: Boolean): State =
      if (state.buffer == "") state.copy(symbolAdjacent = false)
      else {
        val updatedPartNumbers =
          if (state.symbolAdjacent || currentlyAdjacent) state.buffer.toInt :: state.partNumbers
          else state.partNumbers
        State(partNumbers = updatedPartNumbers, buffer = "", symbolAdjacent = false)
      }

    private def bufferValue(char: Char, currentlySymbolAdjacent: Boolean): State =
      if (currentlySymbolAdjacent)
        state.copy(buffer = s"${state.buffer}$char", symbolAdjacent = true)
      else
        state.copy(buffer = s"${state.buffer}$char")

  private val initialState: State = State(partNumbers = Nil, buffer = "", symbolAdjacent = false)

  val partNumbers: List[Int] =
    val endState = grid.values.foldLeft(initialState) { (state, gridCell) =>
      val currentlySymbolAdjacent = grid.adjacent(gridCell.coordinate).exists(_.value.isSymbolic)
      gridCell.value match
        case SchematicTile.Empty => state.flushBuffer(currentlySymbolAdjacent)
        case SchematicTile.NumericChar(num) => state.bufferValue(num, currentlySymbolAdjacent)
        case SchematicTile.Symbolic(symbol) => state.flushBuffer(true)
    }.flushBuffer(currentlyAdjacent = false)
    endState.partNumbers

}

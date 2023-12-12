package be.jobulcke.aoc.day3

class EngineSchematic(private val schematicLines: List<String>) {
    private val lineLength = schematicLines.first().length
    private val lines = schematicLines.size

    /**
     * @return list of all the positions where a number is adjacent to a symbol
     */
    private val positionsOfAdjacentNumbers: List<Position>
        get() {
            val positions = mutableListOf<Position>()
            schematicLines.forEachIndexed { rowIndex, line ->
                line.forEachIndexed { columnIndex, char ->
                    if (!char.isDigit() && char != '.') {
                        positions.add(Position(rowIndex, columnIndex))
                    }
                }
            }
            return positions
                .flatMap { it.getAdjacentPositions(lines - 1, lineLength - 1) }
                .distinct()
                .filter { schematicLines[it].isDigit() }
        }

    val partNumbers: List<Int>
        get() {
            val partNumbers = mutableListOf<Int>()
            val seenPositions = mutableListOf<Position>()

            positionsOfAdjacentNumbers.forEach {
                if (seenPositions.contains(it)) {
                    return@forEach
                }
                var cursor = findStartPosition(it)
                var partNumberString = ""
                while (schematicLines[cursor].isDigit()) {
                    partNumberString += schematicLines[cursor]
                    seenPositions.add(cursor)
                    cursor++
                }
                partNumbers.add(partNumberString.toInt())
            }
            return partNumbers
        }

    private fun findStartPosition(adjacentNumberPosition: Position): Position {
        var cursor = adjacentNumberPosition.moveLeft()
        while (schematicLines[cursor].isDigit()) {
            cursor--
        }
        return cursor.moveRight()
    }

    /**
     * @return char at the according position in a list of strings, or the default in this use case ('.')
     * if no char could be found at the specified position
     */
    operator fun List<String>.get(position: Position) = this[position.rowIndex].getOrElse(position.columnIndex) { '.' }
}
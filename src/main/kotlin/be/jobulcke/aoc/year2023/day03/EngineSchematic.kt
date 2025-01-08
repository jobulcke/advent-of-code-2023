package be.jobulcke.aoc.year2023.day03

class EngineSchematic(private val schematicLines: List<String>) {
    private val lineLength = schematicLines.first().length
    private val lines = schematicLines.size

    val partNumbers: List<Int>
        get() = getSymbolPositions { !it.isDigit() && it != '.' }
            .flatMap { it.getAdjacentPositions(lines - 1, lineLength - 1) }
            .distinct()
            .filter { schematicLines[it].isDigit() }
            .let(::extractNumbers)

    val gearsRatios: List<Int>
        get() =
            getSymbolPositions { it == '*' }
                .map { position ->
                    position.getAdjacentPositions(lines - 1, lineLength - 1)
                        .distinct()
                        .filter { schematicLines[it].isDigit() }
                        .let(::extractNumbers)
                }
                .filter { it.size == 2 }
                .map { it.reduce { a, b -> a * b } }

    private fun getSymbolPositions(predicate: (Char) -> Boolean): List<Position> {
        val positions = mutableListOf<Position>()
        schematicLines.forEachIndexed { rowIndex, line ->
            line.forEachIndexed { columnIndex, char ->
                if (predicate(char)) {
                    positions.add(Position(rowIndex, columnIndex))
                }
            }
        }
        return positions
    }

    private fun extractNumbers(positions: List<Position>): List<Int> {
        val partNumbers = mutableListOf<Int>()
        val seenPositions = mutableListOf<Position>()

        positions.forEach {
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
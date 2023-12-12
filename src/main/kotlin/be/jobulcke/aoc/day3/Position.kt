package be.jobulcke.aoc.day3

data class Position(val rowIndex: Int, val columnIndex: Int) {

    fun moveLeft() = Position(rowIndex, columnIndex - 1)
    fun moveRight() = Position(rowIndex, columnIndex + 1)

    /**
     * Moves the position to the left
     */
    operator fun dec() = moveLeft()

    /**
     * Moves the position to the right
     */
    operator fun inc() = moveRight()


    fun getAdjacentPositions(rowMax: Int, columnMax: Int, rowMin: Int = 0, columnMin: Int = 0): List<Position> {
        return (rowIndex - 1..rowIndex + 1).flatMap { row ->
            (columnIndex - 1..columnIndex + 1).map { column ->
                Position(row, column)
            }
        }
            .filter { it != this }
            .filter {
                it.rowIndex >= rowMin
                        && it.columnIndex >= columnMin
                        && it.rowIndex <= rowMax
                        && it.columnIndex <= columnMax
            }
    }

}
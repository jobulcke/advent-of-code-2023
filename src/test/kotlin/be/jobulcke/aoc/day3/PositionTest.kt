package be.jobulcke.aoc.day3

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class PositionTest {

    @ParameterizedTest(name = "Position({0},{1}) has {2} adjacent positions")
    @MethodSource("indicesAndExpectedSize")
    fun test_GetAdjacentPositions(rowIndex: Int, columnIndex: Int, adjacentPositionsSize: Int) {
        val startPosition = Position(rowIndex, columnIndex)

        val adjacentPositions = startPosition.getAdjacentPositions(2, 2)

        assertThat(adjacentPositions).hasSize(adjacentPositionsSize)
    }

    companion object {
        @JvmStatic
        fun indicesAndExpectedSize() = listOf(
            Arguments.of(1, 1, 8),
            Arguments.of(2, 2, 3),
            Arguments.of(0, 0, 3),
            Arguments.of(1, 2, 5)
        )
    }

}
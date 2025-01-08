package be.jobulcke.aoc.year2023.day06

import be.jobulcke.aoc.year2023.day06.Race
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class RaceTest {

    @ParameterizedTest
    @MethodSource("races")
    fun test_NumberOfWaysToWin(race: Race, expectedWaysToWin: Int) {
        assertThat(race.numberOfWaysToWin).isEqualTo(expectedWaysToWin)
    }

    companion object {
        @JvmStatic
        fun races() = listOf(
                Arguments.of(Race(7, 9), 4),
                Arguments.of(Race(15, 40), 8),
                Arguments.of(Race(30, 200), 9),
            )

    }
}
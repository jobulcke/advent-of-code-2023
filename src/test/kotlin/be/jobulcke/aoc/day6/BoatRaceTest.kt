package be.jobulcke.aoc.day6

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import kotlin.io.path.Path
import kotlin.io.path.readLines

class BoatRaceTest {
    @Test
    fun given_TwoLines_when_ParseLines_then_ReturnBoatRace() {
        val lines = Path("src/test/resources/day6.txt").readLines()
        val expectedBoatRace = BoatRace(
            listOf(Race(7, 9), Race(15, 40), Race(30, 200))
        )

        val boatRace = BoatRace.parse(lines)

        assertThat(boatRace).isEqualTo(expectedBoatRace)
    }

    @ParameterizedTest
    @ValueSource(strings = ["", "line1", "line1\nline2\nline3"])
    fun given_InvalidLines_when_ParseLines_then_ThrowException(input: String) {
        val lines = input.split("\n")

        assertThatThrownBy { BoatRace.parse(lines) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("Input lines must have 2 lines")
    }
}
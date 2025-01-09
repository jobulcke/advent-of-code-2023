package be.jobulcke.aoc.year2024.day7

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CalibrationTest {
    @Test
    fun `test parse`() {
        val input = "190: 10 19"
        val expected = Calibration(190, listOf(10, 19))

        val result = Calibration.parse(input)

        assertThat(result).isEqualTo(expected)
    }

    @ParameterizedTest
    @ValueSource(strings = ["190: 10 19", "3267: 81 40 27", "292: 11 6 16 20", "5500: 5 951 745"])
    fun `test isValid`(input: String) {
        val result = Calibration.parse(input).isValid

        assertThat(result).isTrue()
    }

    @ParameterizedTest
    @ValueSource(strings = ["83: 17 5", "156: 15 6", "7290: 6 8 6 15", "161011: 16 10 13", "192: 17 8 14", "21037: 9 7 18 13", "1700: 5 951 745"])
    fun test_isInvalid(input: String) {
        val result = Calibration.parse(input).isValid

        assertThat(result).isFalse()
    }

    @ParameterizedTest
    @ValueSource(strings = ["190: 10 19", "3267: 81 40 27", "292: 11 6 16 20", "5500: 5 951 745", "156: 15 6", "7290: 6 8 6 15", "192: 17 8 14"])
    fun `test isKindaValid`(input: String) {
        val result = Calibration.parse(input).isKindaValid

        assertThat(result).isTrue()
    }

    @ParameterizedTest
    @ValueSource(strings = ["83: 17 5", "161011: 16 10 13", "21037: 9 7 18 13", "1700: 5 951 745"])
    fun test_isKindaInvalid(input: String) {
        val result = Calibration.parse(input).isKindaValid

        assertThat(result).isFalse()
    }
}
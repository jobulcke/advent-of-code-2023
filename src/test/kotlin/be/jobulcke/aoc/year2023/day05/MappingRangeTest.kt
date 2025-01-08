package be.jobulcke.aoc.year2023.day05

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class MappingRangeTest {
    @ParameterizedTest
    @ValueSource(strings = ["12 15", "12 15 17 20"])
    fun given_InvalidLines_when_ParseLine_then_ThrowException(line: String) {
        Assertions.assertThatThrownBy { MappingRange.parse(line) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("Input line does not contain exactly 3 elements")
    }

    @Test
    fun given_SingleValidLine_when_ParseLine_then_ReturnMapWith48Entries() {
        val line = "52 50 48"
        val expectedMappingRange = MappingRange(50, 52, 48)

        val actualMappingRange = MappingRange.parse(line)

        assertThat(actualMappingRange).isEqualTo(expectedMappingRange)
    }
}
package be.jobulcke.aoc.day1

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class CalibrationDocumentLineTest {

    @ParameterizedTest(name = "Given {0} when line value is retrieved then return {1}")
    @MethodSource("documentLines")
    fun given_StringLine_when_LineValueIsRetrieved_then_ReturnIntegerValue(line: String, value: Int) {
        val document = CalibrationDocumentLine(line)

        assertThat(document.value).isEqualTo(value)
    }

    @ParameterizedTest(name = "Given {0} when line value is retrieved then return {1}")
    @MethodSource("advancedDocumentLines")
    fun given_AdvancedStringLine_when_LineValueIsRetrieved_then_ReturnIntegerValue(line: String, value: Int) {
        val document = CalibrationDocumentLine(line)

        assertThat(document.value).isEqualTo(value)
    }

    companion object {
        @JvmStatic
        fun documentLines() = listOf(
            Arguments.of("1abc2", 12),
            Arguments.of(" pqr3stu8vwx", 38),
            Arguments.of("a1b2c3d4e5f", 15),
            Arguments.of("treb7uchet", 77)
        )

        @JvmStatic
        fun advancedDocumentLines() = listOf(
            Arguments.of("eightwothree", 83),
            Arguments.of("abcone2threexyz", 13),
            Arguments.of("xtwone3four", 24),
            Arguments.of("4nineeightseven2", 42),
            Arguments.of("zoneight234", 14),
            Arguments.of("7pqrstsixteen", 76),

        )
    }
}
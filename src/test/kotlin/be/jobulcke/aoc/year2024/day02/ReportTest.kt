package be.jobulcke.aoc.year2024.day02

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class ReportTest {

    @Test
    fun `test Parsing`() {
        val input = "7 6 4 2 1"
        val expected =  Report.of(7, 6, 4, 2, 1)

        val actual = Report.parse(input)

        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `test IsIncreasing`() {
        val report = Report.parse("1 3 6 7 9")

        assertThat(report.isIncreasing).isTrue()
    }

    @Test
    fun `test IsNotIncreasing`() {
        val report = Report.parse("9 7 6 2 1")

        assertThat(report.isIncreasing).isFalse()
    }

    @ParameterizedTest
    @ValueSource(strings = ["7 6 4 2 1", "1 3 6 7 9"])
    fun `test SafeReports`(line: String) {
        val report = Report.parse(line)

        assertThat(report.isSafe).isTrue()
    }

    @ParameterizedTest
    @ValueSource(strings = ["1 2 7 8 9", "9 7 6 2 1", "1 3 2 4 5", "8 6 4 4 1"])
    fun `test UnsafeReports`(line: String) {
        val report = Report.parse(line)

        assertThat(report.isSafe).isFalse()
    }

    @ParameterizedTest
    @ValueSource(strings = ["1 2 7 8 9", "9 7 6 2 1"])
    fun `test IsKindaUnsafeReports`(line: String) {
        val report = Report.parse(line)

        assertThat(report.isKindaSafe()).isFalse()
    }

    @ParameterizedTest
    @ValueSource(strings = ["7 6 4 2 1", "1 3 6 7 9", "1 3 2 4 5", "8 6 4 4 1", "71 69 70 71 72 75"])
    fun `test IsKindaSafeReports`(line: String) {
        val report = Report.parse(line)

        assertThat(report.isKindaSafe()).isTrue()
    }

    @Test
    fun `test GetAllSafeReports`() {
        val safeReportsCount = javaClass.classLoader.getResource("2024/day2.txt")!!
            .readText()
            .trim()
            .lines()
            .map { Report.parse(it) }
            .count { it.isSafe }

        assertThat(safeReportsCount).isEqualTo(2)
    }
}
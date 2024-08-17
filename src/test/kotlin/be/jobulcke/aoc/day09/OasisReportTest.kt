package be.jobulcke.aoc.day09

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.io.path.Path
import kotlin.io.path.readLines

class OasisReportTest {
    @Test
    fun test_Parsing() {
        val expectedOasisReport = OasisReport(
            listOf(
                OasisHistory(listOf(0, 3, 6, 9, 12, 15)),
                OasisHistory(listOf(1, 3, 6, 10, 15, 21)),
                OasisHistory(listOf(10, 13, 16, 21, 30, 45))
            )
        )

        val actualOasisReport = OasisReport.parse(Path("src/test/resources/day9.txt").readLines())

        assertThat(actualOasisReport).isEqualTo(expectedOasisReport)
    }
}
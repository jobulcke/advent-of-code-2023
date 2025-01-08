package be.jobulcke.aoc.year2023.day01

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import kotlin.io.path.Path
import kotlin.io.path.readLines

class CalibrationDocumentTest {

    @Test
    fun given_ExampleInput_then_Return142() {
        val calibrationValue = Path("src/test/resources/2023/day1.txt").readLines()
            .let { CalibrationDocument.fromStringLines(it).calibrationValue }

        assertThat(calibrationValue).isEqualTo(142)
    }
}
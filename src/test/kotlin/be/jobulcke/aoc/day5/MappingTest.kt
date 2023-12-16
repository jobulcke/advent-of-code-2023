package be.jobulcke.aoc.day5

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MappingTest {
    @Test
    fun test_Parsing() {
        val lines = "water-to-light map:\n88 18 7\n18 25 70".split("\n")
        val expectedMapping = Mapping(
            "water-to-light",
            listOf(
                MappingRange(18, 88, 7),
                MappingRange(25, 18, 70)
            )
        )

        val actualMapping = Mapping.parse(lines)

        assertThat(actualMapping).isEqualTo(expectedMapping)
    }
}
package be.jobulcke.aoc.year2024.day01

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LocationListsTest {
    @Test
    fun `test ReadLocationList`() {
        val input = """
            1   2
            4   5
        """.trimIndent()
        val expected = LocationLists(listOf(1, 4), listOf(2, 5))

        val actual = LocationLists.readLocationLists(input.split("\n"))

        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `test GetTotalDistance`() {
        val locationLists =
            LocationLists.readLocationLists(javaClass.classLoader.getResource("2024/day1.txt")?.readText() ?: "")

        val totalDistance = locationLists.getTotalDistance()

        assertThat(totalDistance).isEqualTo(11)
    }

    @Test
    fun `test CalculateSimilarity`() {
        val locationLists =
            LocationLists.readLocationLists(javaClass.classLoader.getResource("2024/day1.txt")?.readText() ?: "")

        val similarity = locationLists.calculateSimilarity()

        assertThat(similarity).isEqualTo(31)
    }
}
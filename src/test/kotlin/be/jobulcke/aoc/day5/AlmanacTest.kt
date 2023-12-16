package be.jobulcke.aoc.day5

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.io.path.Path
import kotlin.io.path.readLines

class AlmanacTest {

    @Test
    fun given_ExampleInput_when_ParseLines_then_ReturnAlmanac() {
        val actualAlmanac = Path("src/test/resources/day5/example.txt")
            .readLines()
            .let(Almanac::parse)

        assertThat(actualAlmanac.seeds).containsExactly(79, 14, 55, 13)
        assertThat(actualAlmanac.mappings).hasSize(7)
    }

    @Nested
    inner class GetLocations {
        private lateinit var almanac: Almanac

        @BeforeEach
        fun setUp() {
            almanac = Path("src/test/resources/day5/example.txt")
                .readLines()
                .let(Almanac::parse)
        }

        @Test
        fun test_GetLocations() {
            val expectedLocations: Map<Long, Long> = mapOf(
                79L to 82,
                14L to 43,
                55L to 86,
                13L to 35
            )

            val actualLocations = almanac.locations

            assertThat(actualLocations).containsExactlyEntriesOf(expectedLocations)
        }

        @Test
        fun given_Almanac_when_GetLocationsFromRange_then_HasMinEqTo46() {
            val lowestLocation = almanac.getLowestLocationFromRange()

            assertThat(lowestLocation).isEqualTo(46)
        }
    }
}
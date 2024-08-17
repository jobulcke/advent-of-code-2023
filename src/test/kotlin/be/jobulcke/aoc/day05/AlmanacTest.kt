package be.jobulcke.aoc.day05

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.io.path.Path
import kotlin.io.path.readLines

class AlmanacTest {

    @Test
    fun given_ExampleInput_when_ParseLines_then_ReturnAlmanac() {
        val actualAlmanac = Path("src/test/resources/day5.txt")
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
            almanac = Path("src/test/resources/day5.txt")
                .readLines()
                .let(Almanac::parse)
        }

        @Test
        fun given_Almanac_when_GetLocationForSimpleSeeds_then_Return() {
            val expectedLowestLocation: Long = 35

            val actualLowestLocation = almanac.getLowestLocationForSimpleSeeds()

            assertThat(actualLowestLocation).isEqualTo(expectedLowestLocation)
        }

        @Test
        fun given_Almanac_when_GetLowestLocationForSeedRanges_then_Return46() {
            val expectedLowestLocation: Long = 46

            val actualLowestLocation = almanac.getLowestLocationForSeedRanges()

            assertThat(actualLowestLocation).isEqualTo(expectedLowestLocation)
        }
    }
}
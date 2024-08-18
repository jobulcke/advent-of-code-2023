package be.jobulcke.aoc.day15

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.DynamicTest.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestFactory

class HolidayAsciiStringHasherTest {

    @Test
    fun given_HASH_when_convertToHolidayAsciiHash_then_Return52() {
        val input = "HASH";
        val expectedHash = 52

        val actualHash = hashToHolidayAscii(input)

        assertThat(actualHash).isEqualTo(expectedHash)
    }

    @TestFactory
    fun test_HashToHolidayAscii() = listOf(
        "HASH" to 52,
        "rn=1" to 30,
        "cm-" to 253,
        "ot=7" to 231,
        "rn" to 0
    )
        .map { (input, expectedHash) ->
            dynamicTest("given $input, when I convert to Holiday ASCII Hash, then I receive $expectedHash") {
                assertThat(hashToHolidayAscii(input)).isEqualTo(expectedHash)
            }
        }

}
package be.jobulcke.aoc.year2024.day03

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

private const val INPUT = "xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))"

class MemoryTest {
    @Test
    fun `test read`() {
        val expected = Memory(
            listOf(
                Mul(1, Multiplication(2, 4)),
                Mul(28, Multiplication(5, 5)),
                Mul(48, Multiplication(11, 8)),
                Mul(64, Multiplication(8, 5))
            ),
            listOf(
                Do(59)
            ),
            listOf(
                Dont(20)
            )
        )

        val result = Memory.read(INPUT)

        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `test GetSumOfAllMultiplications`() {
        val memory = Memory.read(INPUT)

        val result = memory.sumOfAllMuls

        assertThat(result).isEqualTo(161)
    }

    @Test
    fun `test GetEnabledMuls`() {
        val expectedMuls = listOf(
            Mul(1, Multiplication(2, 4)),
            Mul(64, Multiplication(8, 5))
        )

        val enabledMuls = Memory.read(INPUT).enabledMuls

        assertThat(enabledMuls).containsExactlyInAnyOrderElementsOf(expectedMuls)
    }

    @Test
    fun `test sumOfEnabledMuls`() {
        val expectedSum = 48

        val result = Memory.read(INPUT).sumOfEnabledMuls

        assertThat(result).isEqualTo(expectedSum)
    }
}
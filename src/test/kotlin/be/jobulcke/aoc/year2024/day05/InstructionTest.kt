package be.jobulcke.aoc.year2024.day05

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class InstructionTest {
    @Test
    fun `test fromString`() {
        val input = "75,47,61,53,29"
        val expected = Instruction(listOf(75, 47, 61, 53, 29))

        val actual = Instruction.fromString(input)

        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `test MiddlePage`() {
        val instruction = Instruction(listOf(75, 47, 61, 53, 29))
        val expectedMiddlePage = 61

        val actualMiddlePage = instruction.middlePage

        assertThat(actualMiddlePage).isEqualTo(expectedMiddlePage)
    }
}
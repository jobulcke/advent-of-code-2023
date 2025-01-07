package be.jobulcke.aoc.year2024.day05

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.InstanceOfAssertFactories
import org.junit.jupiter.api.Test

class SafetyManualTest {
    @Test
    fun `test FromString`() {
        val rules = mapOf(
            47 to listOf(53, 13, 61, 29),
            97 to listOf(13, 61, 47, 29, 53, 75),
            75 to listOf(29, 53, 47, 61, 13),
            61 to listOf(13, 53, 29),
            29 to listOf(13),
            53 to listOf(29, 13),
        )
        val instructions = listOf(
            Instruction.of(75, 47, 61, 53, 29),
            Instruction.of(97, 61, 53, 29, 13),
            Instruction.of(75, 29, 13),
            Instruction.of(75, 97, 47, 61, 53),
            Instruction.of(61, 13, 29),
            Instruction.of(97, 13, 75, 29, 47),
        )
        val actual = javaClass.getResource("/2024/day5.txt")?.let { SafetyManual.parse(it.readText()) }

        assertThat(actual?.pageOrderingRules?.rules)
            .containsOnlyKeys(rules.keys)
            .extractingFromEntries ({ (it.key to it.value.map { rule -> rule.second } )})
            .containsExactlyInAnyOrderElementsOf(rules.toList())
        assertThat(actual?.instructions).containsExactlyInAnyOrderElementsOf(instructions)
    }

    @Test
    fun `test GetValidInstructions`() {
        val safetyManual = javaClass.getResource("/2024/day5.txt")?.let { SafetyManual.parse(it.readText()) }

        assertThat(safetyManual?.getValidInstructions()).hasSize(3)
    }

    @Test
    fun `test GetCorrectedInstructions`() {
        val safetyManual = javaClass.getResource("/2024/day5.txt")?.let { SafetyManual.parse(it.readText()) }

        assertThat(safetyManual?.getCorrectedInstructions()).containsExactlyInAnyOrder(
            Instruction.of(97, 75, 47, 61, 53),
            Instruction.of(97, 75, 47, 29, 13),
            Instruction.of(61, 29, 13)
        )
    }
}
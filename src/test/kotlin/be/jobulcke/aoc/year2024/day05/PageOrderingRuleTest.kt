package be.jobulcke.aoc.year2024.day05

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PageOrderingRuleTest {
    @Test
    fun `test fromString`() {
        val input = "47|53"
        val expected = PageOrderingRule(47, 53)

        val actual = PageOrderingRule.fromString(input)

        assertThat(actual).isEqualTo(expected)
    }
}
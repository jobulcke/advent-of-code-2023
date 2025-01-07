package be.jobulcke.aoc.year2024.day05

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.InstanceOfAssertFactories
import org.junit.jupiter.api.Test

class PageOrderingRulesTest {
    @Test
    fun `test OneKeyProvided`() {
        val input = """
97|13
97|61
97|47
""".trimIndent()
            .split("\n")
            .map { PageOrderingRule.fromString(it) }

        val expected = PageOrderingRules(
            mapOf(
                97 to listOf(13, 61, 47)
            )
        )

        val actual = PageOrderingRules.fromRuleset(input)

        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `test MultipleKeysProvided`() {
        val input = """
47|53
97|13
97|61
97|47
75|29
61|13
75|53
""".trimIndent()
            .split("\n")
            .map { PageOrderingRule.fromString(it) }

        val expected = PageOrderingRules(
            mapOf(
                97 to listOf(13, 61, 47),
                47 to listOf(53),
                75 to listOf(29, 53),
                61 to listOf(13)
            )
        )

        val actual = PageOrderingRules.fromRuleset(input)

        assertThat(actual)
            .extracting(PageOrderingRules::rules, InstanceOfAssertFactories.map(Int::class.java, List::class.java))
            .containsExactlyInAnyOrderEntriesOf(expected.rules)
    }
}
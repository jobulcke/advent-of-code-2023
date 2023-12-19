package be.jobulcke.aoc.day7

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.io.path.Path
import kotlin.io.path.readLines

class CamelCardsTest {
    private lateinit var lines: List<String>

    @BeforeEach
    fun setUp() {
        lines = Path("src/test/resources/day7.txt").readLines()
    }

    @Test
    fun test_GetResult() {
        val camelCards = CamelCards.parse(lines)

        assertThat(camelCards.result).isEqualTo(6440)
    }

    @Test
    fun test_GetResultWithJokers() {
        val camelCards = CamelCards.parseWithJokers(lines)

        assertThat(camelCards.result).isEqualTo(5905)
    }
}
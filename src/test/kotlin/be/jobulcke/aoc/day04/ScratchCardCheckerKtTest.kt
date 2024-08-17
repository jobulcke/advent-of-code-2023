package be.jobulcke.aoc.day04

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import kotlin.io.path.Path
import kotlin.io.path.readLines

class ScratchCardCheckerKtTest {
    @Test
    fun test_checkCards() {
        val scratchCards = Path("src/test/resources/day4.txt").readLines()
            .map(ScratchCard::fromLine)

        val totalCards = checkCards(scratchCards)

        assertThat(totalCards).isEqualTo(30)
    }
}
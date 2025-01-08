package be.jobulcke.aoc.year2023.day04

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import kotlin.io.path.Path
import kotlin.io.path.readLines

class ScratchCardCheckerKtTest {
    @Test
    fun test_checkCards() {
        val scratchCards = javaClass.classLoader.getResource("2023/day4.txt")!!.readText()
            .lines()
            .map(ScratchCard::fromLine)

        val totalCards = checkCards(scratchCards)

        assertThat(totalCards).isEqualTo(30)
    }
}
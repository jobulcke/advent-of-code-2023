package be.jobulcke.aoc.year2023.day04

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import kotlin.io.path.Path
import kotlin.io.path.readLines

class ScratchCardTest {

    @Test
    fun test_FromLineConstruction() {
        val line = "Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53"
        val expectedCard = ScratchCard(1, listOf(41, 48, 83, 86, 17), listOf(83, 86, 6, 31, 17, 9, 48, 53))

        val fromLineConstructedCard = ScratchCard.fromLine(line)

        assertThat(fromLineConstructedCard).isEqualTo(expectedCard)
    }

    @Test
    fun given_ScratchCardWithFiveMatchingNumber_when_GetPoints_then_Return8() {
        val scratchCard = ScratchCard(1, listOf(41, 48, 83, 86, 17), listOf(83, 86, 6, 31, 17, 9, 48, 53))

        val points = scratchCard.points

        assertThat(points).isEqualTo(8)
    }

    @Test
    fun given_ScratchCardWithFiveMatchingNumber_when_GetWonCards_then_ReturnRange2To5() {
        val scratchCard = ScratchCard(1, listOf(41, 48, 83, 86, 17), listOf(83, 86, 6, 31, 17, 9, 48, 53))

        val wonCards = scratchCard.wonCards

        assertThat(wonCards)
            .startsWith(2)
            .endsWith(5)
    }

    @ParameterizedTest
    @MethodSource("scratchCardsWithPoints")
    fun given_ScratchCard_test_GetPoints(card: ScratchCard, expectedPoints: Int) {
        assertThat(card.points).isEqualTo(expectedPoints)
    }

    @ParameterizedTest
    @MethodSource("scratchCardsWithWonCards")
    fun given_ScratchCard_test_GetWonCards(card: ScratchCard, expectedWonCards: IntRange?) {
        assertThat(card.wonCards).isEqualTo(expectedWonCards)
    }

    companion object {
        private const val TEST_FILE = "src/test/resources/2023/day4.txt"

        @JvmStatic
        fun scratchCardsWithPoints(): List<Arguments> {
            val points = mapOf(1 to 8, 2 to 2, 3 to 2, 4 to 1, 5 to 0, 6 to 0)

            return Path(TEST_FILE).readLines()
                .map(ScratchCard::fromLine)
                .map { Arguments.of(it, points[it.id]) }
        }

        @JvmStatic
        fun scratchCardsWithWonCards(): List<Arguments> {
            val wonCards = mapOf(1 to 2..5, 2 to 3..4, 3 to 4..5, 4 to 5..5, 5 to null, 6 to null)

            return Path(TEST_FILE).readLines()
                .map(ScratchCard::fromLine)
                .map { Arguments.of(it, wonCards[it.id]) }
        }
    }
}
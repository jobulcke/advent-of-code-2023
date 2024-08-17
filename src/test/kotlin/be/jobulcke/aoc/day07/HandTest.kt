package be.jobulcke.aoc.day07

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class HandTest {
    @ParameterizedTest
    @MethodSource("cards")
    fun test_GetHandType(cards: String, expectedHandType: HandType) {
        val hand = Hand(cards.filter { !it.isWhitespace() }.map(Card::fromChar), 0)

        val actualHandType = hand.handType

        assertThat(actualHandType).isEqualTo(expectedHandType)
    }

    @ParameterizedTest
    @MethodSource("cardsWithJoker")
    fun test_GetHandTypeWithJokers(cards: String, expectedHandType: HandType) {
        val hand = cards
            .filter { !it.isWhitespace() }
            .map(Card::fromCharWithJoker)
            .let { Hand(it, 0) }

        val actualHandType = hand.handType

        assertThat(actualHandType).isEqualTo(expectedHandType)
    }

    @Test
    fun test_GetCardsWithReplacedJokers() {
        val hand = Hand.parseWithJokers("QQJKK 200")

        assertThat(hand.cardsWithReplacedJokers)
            .containsExactlyInAnyOrder(Card.QUEEN, Card.QUEEN, Card.KING, Card.KING, Card.KING)
    }

    @Test
    fun test_GetCardsWithReplacedJokers2() {
        val hand = Hand.parseWithJokers("QJJJK 200")

        assertThat(hand.cardsWithReplacedJokers)
            .containsExactlyInAnyOrder(Card.QUEEN, Card.KING, Card.KING, Card.KING, Card.KING)
    }

    @Test
    fun test_Parsing() {
        val input = "32T3K 765"
        val expectedHand = Hand(listOf(Card.THREE, Card.TWO, Card.TEN, Card.THREE, Card.KING), 765)

        val actualHand = Hand.parse(input)

        assertThat(actualHand).isEqualTo(expectedHand)
    }

    companion object {
        @JvmStatic
        fun cards() = listOf(
            Arguments.of("32T3K", HandType.ONE_PAIR),
            Arguments.of("T55J5", HandType.THREE_OF_A_KIND),
            Arguments.of(" KK677", HandType.TWO_PAIR),
            Arguments.of("KTJJT", HandType.TWO_PAIR),
            Arguments.of("QQQJA", HandType.THREE_OF_A_KIND),
        )

        @JvmStatic
        fun cardsWithJoker() = listOf(
            Arguments.of("32T3K", HandType.ONE_PAIR),
            Arguments.of("T55J5", HandType.FOUR_OF_A_KIND),
            Arguments.of(" KK677", HandType.TWO_PAIR),
            Arguments.of("KTJJT", HandType.FOUR_OF_A_KIND),
            Arguments.of("QQQJA", HandType.FOUR_OF_A_KIND),
        )

    }
}
package be.jobulcke.aoc.year2023.day07

data class Hand(val cards: List<Card>, val bid: Int) : Comparable<Hand> {
    val handType: HandType by lazy {
        if (cards.contains(Card.JOKER)) {
            HandType.getHandType(cardsWithReplacedJokers)
        } else {
            HandType.getHandType(cards)
        }
    }

    val cardsWithReplacedJokers: List<Card>
        get() {
            val highestCard = cards
                .filter { it != Card.JOKER }
                .groupingBy { it }
                .eachCount()
                .toSortedMap(Comparator.comparingInt { -it.value })
                .maxByOrNull { it.value }
                ?.key
                ?: Card.JOKER
            return cards.map { if (it == Card.JOKER) highestCard else it }
        }

    override fun compareTo(other: Hand): Int {
        val handTypeComparing = handType.value.compareTo(other.handType.value)
        if (handTypeComparing != 0) {
            return handTypeComparing
        }
        for ((card1, card2) in cards.zip(other.cards)) {
            val cardComparing = card1.value.compareTo(card2.value)
            if (cardComparing != 0) {
                return cardComparing
            }
        }
        return 0
    }

    companion object {
        fun parse(line: String): Hand {
            val (cards, bid) = line.split(" ")
            return Hand(cards.map(Card.Companion::fromChar), bid.toInt())
        }

        fun parseWithJokers(line: String): Hand {
            val (cards, bid) = line.split(" ")
            return Hand(cards.map(Card.Companion::fromCharWithJoker), bid.toInt())
        }
    }
}
package be.jobulcke.aoc.day7

enum class HandType(val value: Int, private val predicate: (Collection<Int>) -> Boolean) {
    FIVE_OF_A_KIND(7, { it.contains(5) }),
    FOUR_OF_A_KIND(6, { it.contains(4) }),
    FULL_HOUSE(5, { it.containsAll(listOf(3, 2)) }),
    THREE_OF_A_KIND(4, { it.containsAll(listOf(3, 1)) }),
    TWO_PAIR(3, { it.count { counted -> counted == 2 } == 2 }),
    ONE_PAIR(2, { it.count { counted -> counted == 1 } == 3 }),
    HIGH_CARD(1, { it.size == 5 });


    companion object {
        fun getHandType(cards: List<Card>): HandType {
            return entries
                .sortedBy { it.value }
                .first { list -> list.predicate(cards.groupingBy { it }.eachCount().values) }
        }
    }


}

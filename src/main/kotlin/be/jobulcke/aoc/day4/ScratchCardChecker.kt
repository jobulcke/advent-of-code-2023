package be.jobulcke.aoc.day4

fun checkCards(scratchCards: List<ScratchCard>): Int {
    val cardsToCheck = scratchCards.associate { it.id to 1 }.toMutableMap()

    for (scratchCard in scratchCards) {
        for (i in 1..(cardsToCheck[scratchCard.id] ?: 1)) {
            if (scratchCard.wonCards != null) {
                for (id in scratchCard.wonCards!!) {
                    cardsToCheck[id] = cardsToCheck[id]!! + 1
                }
            }
        }
    }
    return cardsToCheck.values.sum()
}


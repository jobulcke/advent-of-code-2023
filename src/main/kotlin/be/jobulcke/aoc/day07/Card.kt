package be.jobulcke.aoc.day07

enum class Card(val label: Char, val value: Int) {
    ACE('A', 14),
    KING('K', 13),
    QUEEN('Q', 12),
    JACK('J', 11),
    TEN('T', 10),
    NINE(9),
    EIGHT(8),
    SEVEN(7),
    SIX(6),
    FIVE(5),
    FOUR(4),
    THREE(3),
    TWO(2),
    JOKER('J', 1);

    constructor(value: Int) : this(value.digitToChar(), value)

    companion object {
        fun fromChar(label: Char): Card {
            if(label == 'J') {
                return JACK
            }
            return entries.first { it.label == label }
        }

        fun fromCharWithJoker(label: Char): Card {
            if(label == 'J') {
                return JOKER
            }
            return entries.first { it.label == label }
        }
    }
}
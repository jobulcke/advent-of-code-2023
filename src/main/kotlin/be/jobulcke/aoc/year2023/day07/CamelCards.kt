package be.jobulcke.aoc.year2023.day07

class CamelCards(private val hands: List<Hand>) {
    val result: Int by lazy {
        hands.sorted().mapIndexed { index, hand -> (index + 1) * hand.bid }.sum()
    }

    companion object {
        fun parse(lines: List<String>) = CamelCards(lines.map(Hand.Companion::parse))

        fun parseWithJokers(lines: List<String>)= CamelCards(lines.map(Hand.Companion::parseWithJokers))
    }
}
package be.jobulcke.aoc.day6

data class BoatRace(private val races: List<Race>) {
    val marginOfError: Int by lazy {
        races.map(Race::numberOfWaysToWin).reduce { a, b -> a * b }
    }

    companion object {
        fun parse(lines: List<String>): BoatRace {
            val prefixes = listOf("Time: ", "Distance: ")
            return lines
                .also { require(it.size == 2) { "Input lines must have 2 lines" } }
                .mapIndexed { index, line -> line.removePrefix(prefixes[index]) }
                .map { it.split(Regex("\\s")).filter(String::isNotBlank) }
                .let { (times, distances) -> times.zip(distances) }
                .map { Race(it.first.toLong(), it.second.toLong()) }
                .let { BoatRace(it) }
        }
    }
}
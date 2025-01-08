package be.jobulcke.aoc.year2024.day02

data class Report(val levels: List<Int>) {
    private val deltas = levels.zipWithNext { current, next -> next - current }
    val isIncreasing = deltas.count { it > 0 } > deltas.count { it < 0 }
    val isSafe get() = deltas.all { it in 1..3 } || deltas.all { it in -3..-1 }

    fun isKindaSafe(): Boolean {
        if (isSafe) return true
        val indexOfElementToRemove =
            if (isIncreasing) deltas.indexOfFirst { it !in 1..3 } else deltas.indexOfFirst { it !in -3..-1 }

        return (indexOfElementToRemove - 1..indexOfElementToRemove + 1)
            .filter { it >= 0 }
            .map { index -> levels.toMutableList().also { it.removeAt(index) } }
            .any { Report(it).isSafe }
    }


    companion object {
        fun parse(input: String) = Report(input.split(" ").map(String::toInt))
        fun of(vararg levels: Int) = Report(levels.toList())
    }

}
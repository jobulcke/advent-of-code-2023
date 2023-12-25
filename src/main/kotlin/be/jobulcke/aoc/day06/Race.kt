package be.jobulcke.aoc.day06

data class Race(private val time: Long, private val distance: Long) {
    val numberOfWaysToWin: Int get() = (0..time).count { it * (time - it) > distance }
}
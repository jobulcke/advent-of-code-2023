package be.jobulcke.aoc.year2023.day06

import kotlin.io.path.Path
import kotlin.io.path.readLines

fun main() {
    val lines = Path("src/main/resources/2023/day6.txt").readLines()
    val boatRace = BoatRace.parse(lines)

    println("The error margin of the boat race is ${boatRace.marginOfError}")

    val singleRace = lines
        .mapIndexed { index, line -> line.removePrefix(listOf("Time: ", "Distance: ")[index]) }
        .map { it.replace(Regex("\\s"), "") }
        .let { Race(it[0].toLong(), it[1].toLong()) }

    println("The number of ways to single race is ${singleRace.numberOfWaysToWin}")
}
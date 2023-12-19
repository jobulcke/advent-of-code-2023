package be.jobulcke.aoc.day2

import kotlin.io.path.Path
import kotlin.io.path.readLines

fun main() {
    val games =  Path("src/main/resources/day2.txt").readLines()
        .map(Game::fromString)
    val gameIdsSum = games
        .filter { it.isPossibleWith(12, 13, 14) }
        .sumOf(Game::id)

    println("The sum of the ids of the games that are possible is $gameIdsSum")

    val sumOfPowers = games.sumOf(Game::power)

    println("The sum of the power of the games is $sumOfPowers")
}
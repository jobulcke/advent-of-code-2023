package be.jobulcke.aoc.day07

import kotlin.io.path.Path
import kotlin.io.path.readLines

fun main() {
    val lines = Path("src/main/resources/day7.txt").readLines()

    val camelCards = CamelCards.parse(lines)

    println("The result of the camel cards game is ${camelCards.result}")

    val camelCardsWithJokers = CamelCards.parseWithJokers(lines)

    println("The result of the camel cards game is ${camelCardsWithJokers.result}")

}
package be.jobulcke.aoc.year2023.day04

import kotlin.io.path.Path
import kotlin.io.path.readLines

fun main() {
    val scratchCards = Path("src/main/resources/2023/day4.txt").readLines().map(ScratchCard.Companion::fromLine)

    val totalPoints = scratchCards.sumOf(ScratchCard::points)
    println("The Elf's total are in total worth $totalPoints points")

    val totalCards = checkCards(scratchCards)
    println("The Elf has a total of $totalCards cards")

}
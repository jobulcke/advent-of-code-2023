package be.jobulcke.aoc.year2024.day03

import kotlin.io.path.Path
import kotlin.io.path.readText

fun main() {
    val input = Path("src/main/resources/2024/day3.txt").readText()

    val memory = Memory.read(input)

    println("The sum of all the valid multiplications is ${memory.sumOfAllMuls}")

    println("The sum of all the enabled multiplications is ${memory.sumOfEnabledMuls}")
}
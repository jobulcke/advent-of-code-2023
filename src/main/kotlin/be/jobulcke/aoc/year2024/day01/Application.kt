package be.jobulcke.aoc.year2024.day01

import kotlin.io.path.Path
import kotlin.io.path.readLines

fun main() {
    val locationLists = LocationLists.readLocationLists(Path("src/main/resources/2023/2024/day1.txt").readLines())

    println("The total distance is ${locationLists.getTotalDistance()}")
    println("The similarity is ${locationLists.calculateSimilarity()}")
}
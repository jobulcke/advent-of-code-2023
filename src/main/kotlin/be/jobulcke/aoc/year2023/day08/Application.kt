package be.jobulcke.aoc.year2023.day08

import kotlin.io.path.Path
import kotlin.io.path.readLines

fun main() {
    val network = Network.parse(Path("src/main/resources/2023/day8.txt").readLines())

    println("You will reach the end node in the network in ${network.stepsToEndNode} steps")

    println("You will reach the end node in the network via multiple starting nodes in ${network.allStepsToEndNodes} steps")
}
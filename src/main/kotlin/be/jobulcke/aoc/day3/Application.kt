package be.jobulcke.aoc.day3

import kotlin.io.path.Path
import kotlin.io.path.readLines

fun main() {
    val engineSchematic = EngineSchematic(Path("src/main/resources/day3/input.txt").readLines())

    val sumOfNumberParts = engineSchematic.partNumbers.sum()
    println("The sum of the number parts of the engine schematic is $sumOfNumberParts")

    val sumOfGearRatios = engineSchematic.gearsRatios.sum()
    println("The sum of the gear ratios of the engine schematic is $sumOfGearRatios")
}
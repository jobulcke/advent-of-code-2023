package be.jobulcke.aoc.year2023.day03

import kotlin.io.path.Path
import kotlin.io.path.readLines

fun main() {
    val engineSchematic = EngineSchematic(Path("src/main/resources/2023/day3.txt").readLines())

    val sumOfNumberParts = engineSchematic.partNumbers.sum()
    println("The sum of the number parts of the engine schematic is $sumOfNumberParts")

    val sumOfGearRatios = engineSchematic.gearsRatios.sum()
    println("The sum of the gear ratios of the engine schematic is $sumOfGearRatios")
}
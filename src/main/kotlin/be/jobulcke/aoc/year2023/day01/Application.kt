package be.jobulcke.aoc.year2023.day01

import kotlin.io.path.Path
import kotlin.io.path.readLines

fun main() {
    val calibrationValue = Path("src/main/resources/2023/day1.txt").readLines()
        .let { CalibrationDocument.fromStringLines(it).calibrationValue }

    println("The input calibration document has a calibration value of $calibrationValue")
}
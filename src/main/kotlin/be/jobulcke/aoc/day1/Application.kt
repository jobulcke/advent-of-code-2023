package be.jobulcke.aoc.day1

import kotlin.io.path.Path
import kotlin.io.path.readLines

fun main() {
    val calibrationValue = Path("src/main/resources/day1/calibration-document-input.txt").readLines()
        .let { CalibrationDocument.fromStringLines(it).calibrationValue }

    println("The input calibration document has a calibration value of $calibrationValue")

    val calibrationValue2 = Path("src/main/resources/day1/input.txt").readLines()
        .let { CalibrationDocument.fromStringLines(it).calibrationValue }

    println("The input calibration document for the second has a calibration value of $calibrationValue2")
}
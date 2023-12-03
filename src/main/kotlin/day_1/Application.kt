package day_1

import kotlin.io.path.Path
import kotlin.io.path.readLines

fun main() {
    val calibrationValue = Path("src/main/resources/calibration-document-input.txt").readLines()
        .let { CalibrationDocument.fromStringLines(it).calibrationValue }

    println("The input calibration document has a calibration value of $calibrationValue")
}
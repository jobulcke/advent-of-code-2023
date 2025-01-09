package be.jobulcke.aoc.year2024.day7

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.toList
import kotlin.io.path.Path
import kotlin.io.path.readLines

suspend fun main() {
    val calibrations = Path("src/main/resources/2024/day7.txt").readLines().map(Calibration::parse)

    val sumOfValidCalibrationResults = calibrations.asFlow()
        .flowOn(Dispatchers.IO)
        .filter{ it.isValid }
        .toList()
        .sumOf { it.result }


    println("The sum of the valid calibration results is $sumOfValidCalibrationResults")

    val sumOfKindaValidCalibrationResults = calibrations.asFlow()
        .flowOn(Dispatchers.IO)
        .filter{ it.isKindaValid }
        .toList()
        .sumOf { it.result }

    println("The sum of the kinda valid calibration results is $sumOfKindaValidCalibrationResults")
}
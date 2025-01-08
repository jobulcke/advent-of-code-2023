package be.jobulcke.aoc.year2024.day05

import kotlin.io.path.Path
import kotlin.io.path.readText

fun main() {
    val safetyManual = SafetyManual.parse(Path("src/main/resources/2023/2024/day5.txt").readText())

    val sumOfMiddlePagesOfCorrectInstructions = safetyManual.getValidInstructions().sumOf { it.middlePage }

    println("The sum of the middle pages of the correct instructions is $sumOfMiddlePagesOfCorrectInstructions")

    val sumOfMiddlePagesOfCorrectedInstructions = safetyManual.getCorrectedInstructions().sumOf { it.middlePage }

    println("The sum of the middle pages of the corrected instructions is $sumOfMiddlePagesOfCorrectedInstructions")

}
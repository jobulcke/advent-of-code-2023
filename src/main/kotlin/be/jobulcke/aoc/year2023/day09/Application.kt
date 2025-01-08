package be.jobulcke.aoc.year2023.day09

import kotlin.io.path.Path
import kotlin.io.path.readLines

fun main() {
    val oasisReport = OasisReport.parse(Path("src/main/resources/2023/day9.txt").readLines())

    println("The sum of the predications is ${oasisReport.extrapolatedValues}")

    println("The sum of the backwards prediction is ${oasisReport.backWardsExtrapolatedValues}")
}
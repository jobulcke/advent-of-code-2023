package be.jobulcke.aoc.day9

import kotlin.io.path.Path
import kotlin.io.path.readLines

fun main() {
    val oasisReport = OasisReport.parse(Path("src/main/resources/day9.txt").readLines())

    println("The sum of the predications is ${oasisReport.extrapolatedValues}")

    println("The sum of the backwards prediction is ${oasisReport.backWardsExtrapolatedValues}")
}
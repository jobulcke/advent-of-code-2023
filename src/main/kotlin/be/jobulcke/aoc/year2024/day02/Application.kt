package be.jobulcke.aoc.year2024.day02

import kotlin.io.path.Path
import kotlin.io.path.readLines

fun main() {

    val reports = Path("src/main/resources/2024/day2.txt").readLines().map(Report::parse)

    val safeReportsCount = reports.count(Report::isSafe)

    println("The number of safe reports is $safeReportsCount")

    val problemDampenedSafeReports = reports.count(Report::isKindaSafe)

    println("The number of problem dampened safe reports is $problemDampenedSafeReports")
}
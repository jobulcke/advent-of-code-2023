package be.jobulcke.aoc.day15

import kotlin.io.path.Path
import kotlin.io.path.readText

fun main() {
    val initializationSequence = InitializationSequence(Path("src/main/resources/day15.txt").readText())

    val holidayAsciiHash = initializationSequence.holidayAsciiHash

    println("The Holiday ASCII Hash of the provided input is $holidayAsciiHash")

    val focussingPower = initializationSequence.focussingPower

    println("The focussing power is $focussingPower")
}
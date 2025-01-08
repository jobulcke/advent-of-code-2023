package be.jobulcke.aoc.year2023.day04

import kotlin.math.pow

data class ScratchCard(val id: Int, private val winningNumbers: List<Int>, private val numbers: List<Int>) {
    private val amountOfMatchingNumbers: Int by lazy { winningNumbers.count { numbers.contains(it) } }

    val points: Int by lazy {
        2.0.pow(amountOfMatchingNumbers - 1).toInt()
    }

    val wonCards: IntRange? by lazy {
        if (amountOfMatchingNumbers == 0) null else id + 1..id + amountOfMatchingNumbers
    }

    companion object {
        @JvmStatic
        fun fromLine(line: String): ScratchCard {
            val parts = line.split(":")
            val id = parts[0].removePrefix("Card").trim().toInt()
            val numberParts = parts[1].split("|").map {
                it.trim().split(" ").filter(String::isNotBlank).map(String::toInt)
            }
            return ScratchCard(id, numberParts[0], numberParts[1])
        }
    }
}
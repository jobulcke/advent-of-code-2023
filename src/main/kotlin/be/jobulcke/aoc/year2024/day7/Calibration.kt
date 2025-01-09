package be.jobulcke.aoc.year2024.day7

import kotlin.math.pow

data class Calibration(val result: Long, val values: List<Int>) {
    val isValid: Boolean
        get() = validate(listOf(Operation.Addition, Operation.Multiplication))

    val isKindaValid: Boolean
        get() = validate(Operation.entries)

    private fun validate(operations: List<Operation>): Boolean {
        val operationCount = operations.size
        val rows = operationCount.toDouble().pow(values.size - 1).toInt()
        for (i in 0 until rows) {
            var result = values[0].toLong()
            var index = i

            for (j in 0 until values.size - 1) {
                result = operations[index % operationCount].execute(result, values[j + 1])
                index /= operationCount
            }

            if (result == this.result) {
                return true
            }
        }
        return false
    }

    companion object {
        fun parse(input: String): Calibration {
            val (result, values) = input.split(": ")
            return Calibration(result.toLong(), values.split(" ").map(String::toInt))
        }
    }
}
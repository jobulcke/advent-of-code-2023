package be.jobulcke.aoc.day09

data class OasisHistory(val results: List<Int>) {
    val resultPrediction = sequencesWithPrediction.first().last()
    val resultBackwardsPrediction = sequencesWithBackwardsPrediction.first().first()
    val sequences: List<List<Int>>
        get() {
            val sequences = mutableListOf(results)
            while (sequences.last().any { it != 0 }) {
                sequences.add(calculateNextSequence(sequences.last()))
            }
            return sequences
        }

    val sequencesWithPrediction: List<List<Int>>
        get() = calculatePrediction { dataLine, differenceLine -> dataLine + (dataLine.last() + differenceLine.last()) }

    val sequencesWithBackwardsPrediction: List<List<Int>>
        get() = calculatePrediction { dataLine, differenceLine ->
            dataLine.toMutableList().also { it.add(0, dataLine.first() - differenceLine.first()) }
        }

    private fun calculateNextSequence(sequence: List<Int>): List<Int> {
        val nextSequence = mutableListOf<Int>()
        sequence.indices.drop(1).forEach { nextSequence.add(sequence[it] - sequence[it - 1]) }
        return nextSequence
    }

    private fun calculatePrediction(predictionCalculator: (List<Int>, List<Int>) -> List<Int>): List<List<Int>> {
        val calculatedSequences = mutableListOf(sequences.last() + 0)
        sequences.dropLast(1).reversed().forEach {
            calculatedSequences.add(predictionCalculator(it, calculatedSequences.last()))
        }
        return calculatedSequences.reversed()
    }

    companion object {
        fun parse(line: String): OasisHistory {
            return line.trim().split(" ").map(String::toInt).let(::OasisHistory)
        }
    }
}
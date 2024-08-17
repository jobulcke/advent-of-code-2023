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
        sequence.indices.drop(1).spliterator().forEachRemaining { i ->
            val diff = sequence[i] - sequence[i - 1]
            nextSequence.add(diff)
        }
        return nextSequence
    }

    private fun calculatePrediction(predictionCalculator: (List<Int>, List<Int>) -> List<Int>): List<List<Int>> {
        val sequencesWithPrediction = mutableListOf(sequences.last() + 0)
        sequences.dropLast(1).reversed().spliterator().forEachRemaining {
            sequencesWithPrediction.add(predictionCalculator(it, this.sequencesWithPrediction.last()))
        }
        return this.sequencesWithPrediction.reversed()
    }

    companion object {
        fun parse(line: String): OasisHistory {
            return line.trim().split(" ").map(String::toInt).let(::OasisHistory)
        }
    }
}
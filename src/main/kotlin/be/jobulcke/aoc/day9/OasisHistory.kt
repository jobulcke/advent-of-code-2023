package be.jobulcke.aoc.day9

data class OasisHistory(val results: List<Int>) {
    val resultPredication = sequencesWithPredication.first().last()
    val resultBackwardsPrediction = sequencesWithBackwardsPrediction.first().first()
    val sequences: List<List<Int>>
        get() {
            val sequences = mutableListOf(results)
            while (sequences.last().any { it != 0 }) {
                sequences.add(calculateNextSequence(sequences.last()))
            }
            return sequences
        }

    val sequencesWithPredication: List<List<Int>>
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

    private fun calculatePrediction(predicationCalculator: (List<Int>, List<Int>) -> List<Int>): List<List<Int>> {
        val sequencesWithPredication = mutableListOf(sequences.last() + 0)
        sequences.dropLast(1).reversed().spliterator().forEachRemaining {
            sequencesWithPredication.add(predicationCalculator(it, sequencesWithPredication.last()))
        }
        return sequencesWithPredication.reversed()
    }

    companion object {
        fun parse(line: String): OasisHistory {
            return line.trim().split(" ").map(String::toInt).let(::OasisHistory)
        }
    }
}
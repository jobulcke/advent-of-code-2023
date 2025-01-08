package be.jobulcke.aoc.year2023.day15

class Sequence(val label: String, val operationSign: OperationSign, val focalLength: Int? = null) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Sequence

        return label == other.label
    }

    override fun hashCode(): Int {
        return label.hashCode()
    }

    companion object {
        fun fromString(input: String): Sequence {
            require(operationSigns.any { input.contains(it.operationChar) }) {
                "Expected for input to contain one of the following chars: ${operationSigns.map(OperationSign::operationChar)}"
            }
            return operationSigns
                .first { input.contains(it.operationChar) }
                .mapToSequence(input)
        }
    }
}
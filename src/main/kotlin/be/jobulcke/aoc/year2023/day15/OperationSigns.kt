package be.jobulcke.aoc.year2023.day15

val operationSigns = listOf(EqualsSignOperationSign, DashOperationSign)

interface OperationSign {
    val operationChar: Char
    fun mapToSequence(input: String): Sequence
}

object EqualsSignOperationSign : OperationSign {
    override val operationChar: Char
        get() = '='

    override fun mapToSequence(input: String): Sequence {
        require(input.contains(operationChar)) { "Expected input to contain $operationChar" }
        val sequenceParts = input.split(operationChar)
        return Sequence(sequenceParts.first(), this, sequenceParts.last().toInt())
    }
}

object DashOperationSign : OperationSign {
    override val operationChar: Char
        get() = '-'

    override fun mapToSequence(input: String): Sequence {
        require(input.contains(operationChar)) { "Expected input to contain $operationChar" }
        return Sequence(input.split(operationChar).first(), this)
    }
}


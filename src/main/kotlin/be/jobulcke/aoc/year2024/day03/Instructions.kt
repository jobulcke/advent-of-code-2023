package be.jobulcke.aoc.year2024.day03

interface Instruction<T> {
    val start: Int
    fun execute(): T
}

interface BooleanSupplier: Instruction<Boolean>

data class Do(override val start: Int): BooleanSupplier {
    override fun execute() = true

    companion object {
        val regex = Regex("""do\(\)""")
    }
}

data class Dont(override val start: Int): BooleanSupplier {
    override fun execute() = false

    companion object {
        val regex = Regex("""don't\(\)""")
    }
}

data class Mul(override val start: Int, val multiplication: Multiplication): Instruction<Int> {
    override fun execute() = multiplication.result

    companion object {
        val regex = Multiplication.regex
    }
}
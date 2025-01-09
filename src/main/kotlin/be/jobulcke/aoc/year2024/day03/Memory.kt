package be.jobulcke.aoc.year2024.day03

private const val INITIAL_START = 0

data class Memory(val muls: List<Mul>, val dos: List<Do>, val donts: List<Dont>) {
    val sumOfAllMuls get() = muls.sumOf { it.execute() }
    val enabledMuls get() = muls.filter { enabledRanges.any { range -> it.start in range } }
    val sumOfEnabledMuls get() = enabledMuls.sumOf { it.execute() }

    private val enabledRanges: List<IntRange>
        get() {
            val enableInstructions = (dos + donts).sortedBy { it.start }

            val ranges = mutableListOf(INITIAL_START until enableInstructions.first().start)
            enableInstructions.dropLast(1).forEachIndexed { index, booleanSupplier ->
                if (booleanSupplier.execute()) {
                    ranges.add(booleanSupplier.start until enableInstructions[index + 1].start)
                }
            }
            val last = enableInstructions.last()
            if (last.execute()) ranges.add(last.start until Int.MAX_VALUE)
            return ranges
        }

    companion object {
        fun read(input: String) = input.let { Memory(readMuls(it), readDos(it), readDonts(it)) }

        private fun readMuls(input: String): List<Mul> {
            return Mul.regex.findAll(input).map { Mul(it.range.first, Multiplication.parse(it.value)) }.toList()
        }

        private fun readDos(input: String): List<Do> {
            return Do.regex.findAll(input).map { Do(it.range.first) }.toList()
        }

        private fun readDonts(input: String): List<Dont> {
            return Dont.regex.findAll(input).map { Dont(it.range.first) }.toList()
        }
    }
}
package be.jobulcke.aoc.year2024.day03

data class Multiplication(val x: Int, val y: Int){
    val result = x * y

    companion object {
        val regex = Regex("""mul\(\d{1,3},\d{1,3}\)""")

        private val valuesExtractRegex = Regex("""mul\((\d{1,3}),(\d{1,3})\)""")

        fun parse(input: String): Multiplication {
            val (x, y) = valuesExtractRegex.find(input)?.destructured ?: throw IllegalArgumentException("Invalid input: $input")
            return Multiplication(x.toInt(), y.toInt())
        }
    }
}
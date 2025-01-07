package be.jobulcke.aoc.year2024.day05

data class Instruction (val pages: List<Int>) {
    val middlePage: Int
        get() {
            return pages[pages.size / 2]
        }

    fun correct(pagesToCorrect: List<Int>): Instruction {
        return pages.toMutableList().also {
            it.removeAll(pagesToCorrect)
            it.addAll(pagesToCorrect)
        }.let {
            Instruction(it)
        }
    }

    companion object {
        fun fromString(input: String) = Instruction(input.split(",").map(String::toInt))

        fun of(vararg pages: Int) = Instruction(pages.toList())
    }
}
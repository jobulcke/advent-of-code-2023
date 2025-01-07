package be.jobulcke.aoc.year2024.day05

data class PageOrderingRule(val first: Int, val second: Int) {
    companion object {
        fun fromString(line: String): PageOrderingRule {
            val (first, second) = line.split("|")
            return PageOrderingRule(first.toInt(), second.toInt())
        }
    }

    fun validate(currentPage: Int, previousPages: List<Int>): Int? {
        return if(first == currentPage && previousPages.contains(second)) {
            second
        } else {
            null
        }
    }

}
package be.jobulcke.aoc.year2024.day05

data class PageOrderingRules(val pageOrderingRules: List<PageOrderingRule>) {
    val rules: Map<Int, List<PageOrderingRule>> = pageOrderingRules.groupBy({ it.first })

    constructor(rules: Map<Int, List<Int>>) : this(rules.flatMap { (first, seconds) ->
        seconds.map {
            PageOrderingRule(
                first,
                it
            )
        }
    })

    fun validate(page: Int, previousPages: List<Int>): Int? {
        return rules[page]
            ?.filter { it.validate(page, previousPages) != null }
            ?.minByOrNull { previousPages.indexOf(it.second) }
            ?.second
    }

    fun getNextPagesFor(page: Int) = rules[page]?.map { it.second } ?: emptyList()

    operator fun get(page: Int) = rules[page] ?: emptyList()

    companion object {
        fun fromRuleset(pageOrderingRules: List<PageOrderingRule>) = PageOrderingRules(pageOrderingRules)
    }
}
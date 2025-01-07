package be.jobulcke.aoc.year2024.day05

data class SafetyManual(val pageOrderingRules: PageOrderingRules, val instructions: List<Instruction>) {
    fun getValidInstructions(): List<Instruction> {
        return validatedInstructions.first
    }

    fun getCorrectedInstructions(): List<Instruction> {
        return validatedInstructions.second.map {
            val correctedPages = mutableListOf<Int>()
            it.pages.forEachIndexed { index, page ->
                val violatedPage = pageOrderingRules.validate(page, correctedPages)
                if (index > 0 && violatedPage != null) {
                    correctedPages.add(correctedPages.indexOf(violatedPage), page)
                } else {
                    correctedPages.add(page)
                }
            }
            it.correct(correctedPages)
        }
    }

    private val validatedInstructions: Pair<List<Instruction>, List<Instruction>>
        get() {
            return instructions.partition {
                it.pages.mapIndexed { index, page ->
                    val previousIndex = index - 1
                    if (index > 0) {
                        !pageOrderingRules.getNextPagesFor(page).contains(it.pages[previousIndex])
                    } else {
                        true
                    }
                }.all { isValid -> isValid }
            }
        }

    companion object {
        fun parse(input: String): SafetyManual {
            val (pageOrderingRules, instructions) = input.split("\r\n\r\n")
            return SafetyManual(
                PageOrderingRules.fromRuleset(pageOrderingRules.lines().map { PageOrderingRule.fromString(it) }),
                instructions.lines().map { Instruction.fromString(it) }
            )
        }
    }
}
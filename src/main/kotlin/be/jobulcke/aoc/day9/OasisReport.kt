package be.jobulcke.aoc.day9

data class OasisReport(val histories: List<OasisHistory>) {
    val extrapolatedValues = histories.map(OasisHistory::resultPrediction).sum()
    val backWardsExtrapolatedValues = histories.map(OasisHistory::resultBackwardsPrediction).sum()

    companion object {
        fun parse(lines: List<String>) = lines.map(OasisHistory::parse).let(::OasisReport)
    }
}
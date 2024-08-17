package be.jobulcke.aoc.day01

class CalibrationDocument(private val documentLines: List<CalibrationDocumentLine>) {
    val calibrationValue: Int
        get() = documentLines.sumOf { it.value }

    companion object {
        fun fromStringLines(documentLines: List<String>): CalibrationDocument {
            return documentLines
                .map { CalibrationDocumentLine(it) }
                .let { CalibrationDocument(it) }
        }
    }

}
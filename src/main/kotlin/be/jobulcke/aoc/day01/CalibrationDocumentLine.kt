package be.jobulcke.aoc.day01

class CalibrationDocumentLine(private val line: String) {
    val value: Int
        get() {
            val firstInteger = extractDigitFromSingleLine(line, String::indices, this::extractWordlyDigitFromStart)
            val lastInteger =
                extractDigitFromSingleLine(line, { it.indices.reversed() }, this::extractWordlyDigitFromEnd)

            return String(charArrayOf(firstInteger, lastInteger)).toInt()
        }

    private fun extractDigitFromSingleLine(
        line: String,
        indicesExtractor: (String) -> IntProgression,
        wordlyDigitExtractor: (String, Int) -> Char?
    ): Char {
        for (i in indicesExtractor(line)) {
            val char = line[i]
            val intValue = char.digitToIntOrNull()
            if (intValue != null) {
                return char
            }
            val wordlyDigitChar = wordlyDigitExtractor(line, i)
            if (wordlyDigitChar != null) {
                return wordlyDigitChar
            }
        }
        throw IllegalStateException("Document line does not contain a single integer value")
    }

    private fun extractWordlyDigitFromStart(line: String, index: Int): Char? {
        line.substring(index).let {
            for (number in Numbers.entries) {
                if (it.startsWith(number.stringRepresentation))
                    return number.integerValue
            }
        }
        return null
    }

    private fun extractWordlyDigitFromEnd(line: String, index: Int): Char? {
        line.substring(0, index + 1).let {
            for (number in Numbers.entries) {
                if (it.endsWith(number.stringRepresentation))
                    return number.integerValue
            }
        }
        return null
    }
}
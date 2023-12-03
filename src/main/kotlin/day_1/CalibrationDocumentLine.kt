package day_1

import java.util.function.BiFunction
import java.util.function.Function

class CalibrationDocumentLine(private val line: String) {
    val value: Int
        get() {
            val firstInteger =
                extractDigitFromSingleLine(line, { it.indices }, { linePart, number -> linePart.startsWith(number) })
            val lastInteger = extractDigitFromSingleLine(
                line,
                { it.indices.reversed() },
                { linePart, number -> linePart.endsWith(number) })

            return String(charArrayOf(firstInteger, lastInteger)).toInt()
        }

    private fun extractDigitFromSingleLine(
        line: String,
        indicesExtractor: Function<String, IntProgression>,
        predicate: BiFunction<String, String, Boolean>
    ): Char {
        for (i in indicesExtractor.apply(line)) {
            val char = line[i]
            val intValue = char.digitToIntOrNull()
            if (intValue != null) {
                return char
            }
            line.substring(i).let {
                for (number in Numbers.entries) {
                    if (predicate.apply(it, number.stringRepresentation))
                        return number.integerValue
                }
            }
        }
        throw IllegalStateException("Document line does not contain a single integer value")
    }
}
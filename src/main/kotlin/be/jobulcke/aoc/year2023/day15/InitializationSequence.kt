package be.jobulcke.aoc.year2023.day15

class InitializationSequence(private val sequence: String) {
    val holidayAsciiHash: Int
        get() = sequence.split(",").sumOf(::hashToHolidayAscii)

    private val sequences: List<Sequence>
        get() = sequence.split(",").map(Sequence.Companion::fromString)

    val focussingPower: Int
        get() = (0 until 256)
            .map(::Box)
            .also { boxes -> sequences.forEach { boxes[hashToHolidayAscii(it.label)].handleSequence(it) } }
            .sumOf(Box::focussingPower)
}
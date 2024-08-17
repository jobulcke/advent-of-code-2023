package be.jobulcke.aoc.day15

class InitializationSequence(val sequence: String) {
    val holidayAsciiHash: Int
        get() = sequence.split(",").sumOf(::hashToHolidayAscii)
}
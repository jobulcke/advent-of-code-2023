package be.jobulcke.aoc.year2023.day15


fun hashToHolidayAscii(input: String): Int {
    var currentValue = 0

    for (char in input) {
        currentValue += char.code
        currentValue *= 17
        currentValue %= 256
    }

    return currentValue
}

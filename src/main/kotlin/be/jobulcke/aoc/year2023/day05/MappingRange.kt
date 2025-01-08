package be.jobulcke.aoc.year2023.day05

data class MappingRange(val sourceStart: Long, val destinationStart: Long, val rangeLength: Long) {

    /**
     * @return true if the specified source is in the mapping, otherwise false
     */
    operator fun contains(source: Long) = sourceStart <= source && source < sourceStart + rangeLength

    /**
     * @return the destination that is mapped to the specified source
     */
    operator fun get(source: Long) = destinationStart - sourceStart + source

    companion object {
        fun parse(line: String) = line.trim().split(" ")
            .also { require(it.size == 3) { "Input line does not contain exactly 3 elements" } }
            .map(String::toLong)
            .let { MappingRange(it[1], it[0], it[2]) }
    }
}
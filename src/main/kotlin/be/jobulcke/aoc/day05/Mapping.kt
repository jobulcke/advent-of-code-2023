package be.jobulcke.aoc.day05

data class Mapping(val name: String, val mappingRanges: List<MappingRange>) {

    /**
     * @return a destination if the source is part of one of the mappings, or null if the source is found
     */
    operator fun get(source: Long) = mappingRanges.firstOrNull { source in it }?.get(source)

    companion object {
        fun parse(lines: List<String>) = Mapping(
            lines.first().removeSuffix(" map:"),
            lines.drop(1).map(MappingRange::parse)
        )
    }
}
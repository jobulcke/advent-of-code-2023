package be.jobulcke.aoc.year2023.day05

data class Almanac(
    val seeds: List<Long>,
    val mappings: List<Mapping>
) {
    private val seedsRanges: List<LongRange> by lazy {
        seeds.windowed(2, 2).map { (start, length) -> start until start + length }
    }

    private val reversedMappings: List<Mapping> by lazy {
        mappings
            .map { mapping ->
                val mappingRanges =
                    mapping.mappingRanges.map { MappingRange(it.destinationStart, it.sourceStart, it.rangeLength) }
                Mapping(mapping.name, mappingRanges)
            }
            .reversed()
    }

    fun getLowestLocationForSimpleSeeds(): Long = seeds.minOf(::getLocation)
    fun getLowestLocationForSeedRanges(): Long {
        return generateSequence(0L, Long::inc).first { location ->
            val seed = getSeedForLocation(location)
            seedsRanges.any { seedRange -> seed in seedRange }
        }
    }

    private fun getLocation(seed: Long) = getDestinationForSource(seed, mappings)
    private fun getSeedForLocation(location: Long) = getDestinationForSource(location, reversedMappings)

    private fun getDestinationForSource(source: Long, mappings: List<Mapping>): Long {
        var nextSource = source
        for (mapping in mappings) {
            nextSource = mapping[nextSource] ?: nextSource
        }
        return nextSource
    }

    companion object {
        fun parse(lines: List<String>): Almanac {
            return lines.joinToString("\n").split("\n\n")
                .let {
                    Almanac(
                        it.first().removePrefix("seeds: ").trim().split(" ").map(String::toLong),
                        it.drop(1).map { line -> line.split("\n") }.map(Mapping::parse)
                    )
                }
        }
    }
}
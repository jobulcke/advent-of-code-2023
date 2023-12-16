package be.jobulcke.aoc.day5

data class Almanac(
    val seeds: List<Long>,
    val mappings: List<Mapping>
) {
    val locations: Map<Long, Long> = seeds.associateWith(::getLocation)

    fun getLowestLocationFromRange(): Long {
        var lowest = Long.MAX_VALUE
        for (index in seeds.indices step 2) {
            for (seed in seeds[index]..<seeds[index] + seeds[index + 1]) {
                val location = getLocation(seed)
                if (location < lowest) {
                    lowest = location
                }
            }
        }
        return lowest
    }

    private fun getLocation(seed: Long): Long {
        var source = seed
        for (mapping in mappings) {
            source = mapping[source] ?: source
        }
        return source
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
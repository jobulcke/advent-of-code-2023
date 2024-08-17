package be.jobulcke.aoc.day02

data class Game(val id: Int, private val subsets: List<GameSubset>) {

    val fewestPossibleCubes: Map<CubeColor, Int>
        get() {
            val fewestPossibleCubes = mutableMapOf<CubeColor, Int>()
            val allCubes = subsets.map(GameSubset::cubes)
            for (subsetCubes in allCubes) {
                subsetCubes.entries.forEach { (color, amount) ->
                    run {
                        val currentFewestCubes = fewestPossibleCubes.putIfAbsent(color, amount)
                        if (currentFewestCubes != null && amount > currentFewestCubes) {
                            fewestPossibleCubes[color] = amount
                        }
                    }
                }
            }
            return fewestPossibleCubes
        }

    val power: Int = fewestPossibleCubes.values.reduce { acc, i -> acc * i }

    fun isPossibleWith(redCubes: Int, greenCubes: Int, blueCubes: Int): Boolean {
        return subsets.map { it.isPossibleWith(redCubes, greenCubes, blueCubes) }.all { it }
    }


    companion object {
        fun fromString(line: String): Game {
            val lineParts = line.split(":")
            val id = lineParts[0].removePrefix("Game ").trim().toInt()
            val subsets = lineParts[1].split(";").map { GameSubset.fromString(it) }
            return Game(id, subsets)
        }
    }
}
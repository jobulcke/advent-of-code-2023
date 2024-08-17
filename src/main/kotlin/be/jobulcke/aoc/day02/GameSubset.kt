package be.jobulcke.aoc.day02

data class GameSubset(val cubes: Map<CubeColor, Int>) {

    constructor(redCubes: Int = 0, greenCubes: Int = 0, blueCubes: Int = 0) : this(
        mapOf(CubeColor.Red to redCubes, CubeColor.Green to greenCubes, CubeColor.Blue to blueCubes)
    )

    fun getCubesOfCubeColor(color: CubeColor) = cubes.getOrDefault(color, 0)

    fun isPossibleWith(cubes: Map<CubeColor, Int>): Boolean {
        for (color in CubeColor.entries) {
            if (getCubesOfCubeColor(color) > cubes.getOrDefault(color, 0)) {
                return false
            }
        }
        return true
    }

    fun isPossibleWith(redCubes: Int, greenCubes: Int, blueCubes: Int) =
        isPossibleWith(mapOf(CubeColor.Red to redCubes, CubeColor.Green to greenCubes, CubeColor.Blue to blueCubes))

    companion object {
        fun fromString(line: String): GameSubset {
            val entryParts = line.split(",").map(String::trim)
            return CubeColor.entries
                .associateWith { color ->
                    entryParts
                        .find { it.contains(color.value) }
                        ?.removeSuffix(color.value)
                        ?.trim()?.toInt()
                        ?: 0
                }
                .let { GameSubset(it) }
        }
    }
}
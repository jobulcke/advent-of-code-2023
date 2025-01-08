package be.jobulcke.aoc.year2023.day05

import kotlin.io.path.Path
import kotlin.io.path.readLines

fun main() {
    val almanac = Almanac.parse(Path("src/main/resources/2023/day5.txt").readLines())

    val lowestLocation = almanac.getLowestLocationForSimpleSeeds()

    println("The lowest location to the initial seeds is $lowestLocation")

    val lowestLocationFromRange = almanac.getLowestLocationForSeedRanges()

    println("The lowest location from the initial seeds as range is $lowestLocationFromRange")
}
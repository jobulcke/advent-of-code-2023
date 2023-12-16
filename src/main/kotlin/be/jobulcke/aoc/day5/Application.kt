package be.jobulcke.aoc.day5

import kotlin.io.path.Path
import kotlin.io.path.readLines

fun main() {
    val almanac = Almanac.parse(Path("src/main/resources/day5/input.txt").readLines())

    val lowestLocation = almanac.locations.values.min()

    println("The lowest location to the initial seeds is $lowestLocation")

    val lowestLocationFromRange = almanac.getLowestLocationFromRange()

    println("The lowest location from the initial seeds as range is $lowestLocationFromRange")
}
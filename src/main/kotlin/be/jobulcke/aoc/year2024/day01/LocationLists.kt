package be.jobulcke.aoc.year2024.day01

import kotlin.math.abs

data class LocationLists(val leftLocationList: List<Int>, val rightLocationList: List<Int>) {

    fun getTotalDistance(): Int {
        return leftLocationList.sorted().zip(rightLocationList.sorted())
            .sumOf { (location1, location2) -> abs(location1 - location2) }
    }

    fun calculateSimilarity() =
        leftLocationList.sumOf { leftLocationId -> rightLocationList.count { rightLocationId -> leftLocationId == rightLocationId } * leftLocationId }

    companion object {
        fun readLocationLists(input: String) = readLocationLists(input.lines())

        fun readLocationLists(input: List<String>): LocationLists {
            val locationList1 = mutableListOf<Int>()
            val locationList2 = mutableListOf<Int>()
            for (line in input) {
                val (location1, location2) = line.split("   ")
                locationList1.add(location1.toInt())
                locationList2.add(location2.toInt())
            }
            return LocationLists(locationList1, locationList2)
        }
    }
}
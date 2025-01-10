package be.jobulcke.aoc.year2024.day9

import kotlin.io.path.Path
import kotlin.io.path.readText

suspend fun main() {
    val input = Path("src/main/resources/2024/day9.txt").readText()

    val disk = Disk.fromDiskMap(input)

    println("The checksum of the freed up disk is ${disk.freeUpSpaceMessy().checksum}")
    println("The checksum of the clean freed up disk is ${disk.freeUpSpace().checksum}")
}
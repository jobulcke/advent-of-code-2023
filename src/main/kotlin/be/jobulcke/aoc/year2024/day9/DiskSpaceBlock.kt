package be.jobulcke.aoc.year2024.day9

class DiskSpaceBlock(val startIndex: Int, val size: Int, val fileId: String) {
    val isFreeSpace: Boolean = fileId == "."
    val range: IntRange = startIndex until startIndex + size

    operator fun compareTo(other: DiskSpaceBlock): Int = size.compareTo(other.size)

    infix fun isBefore(other: DiskSpaceBlock): Boolean = startIndex < other.startIndex
}
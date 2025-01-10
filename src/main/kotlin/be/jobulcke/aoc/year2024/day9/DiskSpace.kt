package be.jobulcke.aoc.year2024.day9

data class DiskSpace(val index: Int, val fileId: String) {
    val isFreeSpace = fileId == "."

    fun move(to: Int): DiskSpace {
        return DiskSpace(to, fileId)
    }

    override fun toString(): String {
        return fileId.toString()
    }
}
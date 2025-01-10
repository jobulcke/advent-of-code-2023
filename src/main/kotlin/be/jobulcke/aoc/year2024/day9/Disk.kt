package be.jobulcke.aoc.year2024.day9

data class Disk(val diskLayout: List<DiskSpace>) {
    val checksum: Long
        get() = diskLayout
            .filter { !it.isFreeSpace }
            .sumOf { it.fileId.toLong() * it.index }

    fun freeUpSpaceMessy(): Disk {
        val newDiskLayout = diskLayout.toMutableList()

        while (!isFreedUp(newDiskLayout)) {
            val firstFreeSpace = newDiskLayout.first(DiskSpace::isFreeSpace)
            val lastFile = newDiskLayout.last { !it.isFreeSpace }

            newDiskLayout[firstFreeSpace.index] = lastFile.move(firstFreeSpace.index)
            newDiskLayout[lastFile.index] = firstFreeSpace.move(lastFile.index)
        }

        return Disk(newDiskLayout)
    }

    fun freeUpSpace(): Disk {
        val newDiskLayout = diskLayout.toMutableList()
        val blocks = extractDiskSpaceBlocks(diskLayout)
        var lastFileBlock = blocks.last { !it.isFreeSpace }
        var freeSpaces = blocks.filter { it.isFreeSpace }

        while (lastFileBlock.startIndex > freeSpaces.first().startIndex) {
            freeSpaces.firstOrNull { it >= lastFileBlock && it isBefore lastFileBlock }?.let { freeSpace ->
                lastFileBlock.range.forEach { newDiskLayout[it] = DiskSpace(it, ".") }
                (0 until lastFileBlock.size)
                    .map { freeSpace.startIndex + it }
                    .forEach { newDiskLayout[it] = DiskSpace(it, lastFileBlock.fileId) }
            }

            lastFileBlock = blocks.last { it.fileId == lastFileBlock.fileId.toLong().minus(1).toString() }
            freeSpaces = extractFreeSpaces(newDiskLayout)
        }

        return Disk(newDiskLayout)
    }

    private fun isFreedUp(diskLayout: List<DiskSpace>) =
        diskLayout.subList(diskLayout.indexOfFirst(DiskSpace::isFreeSpace), diskLayout.size)
            .all(DiskSpace::isFreeSpace)

    private fun extractDiskSpaceBlocks(spaces: List<DiskSpace>) =
        spaces.map {
            DiskSpaceBlock(
                it.index,
                diskLayout.subList(it.index, diskLayout.size)
                    .takeWhile { diskSpace -> diskSpace.fileId == it.fileId }.size,
                it.fileId
            )
        }
            .toList()
            .distinctBy { it.range.last }

    private fun extractFreeSpaces(spaces: List<DiskSpace>) = extractDiskSpaceBlocks(spaces.filter(DiskSpace::isFreeSpace))


    override fun toString(): String {
        return diskLayout.joinToString("", transform = DiskSpace::toString)
    }

    companion object {
        fun fromString(input: String): Disk {
            return Disk(input.toCharArray().mapIndexed { index, c -> DiskSpace(index, c.toString()) })
        }

        fun fromDiskMap(diskMap: String): Disk {
            var currentFileId = -1
            var cursor = 0
            return diskMap.toCharArray().map(Char::digitToInt).flatMapIndexed { index, size ->
                val fileId = if (index % 2 == 0) (++currentFileId).toString() else "."
                (0 until size).map { i -> DiskSpace(cursor + i, fileId) }.also { cursor += size }
            }.let { Disk(it) }
        }
    }
}
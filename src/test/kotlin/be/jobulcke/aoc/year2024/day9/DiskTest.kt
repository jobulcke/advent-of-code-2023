package be.jobulcke.aoc.year2024.day9

import kotlinx.coroutines.runBlocking
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Condition
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class DiskTest {

    @ParameterizedTest
    @CsvSource(value = ["12345,0..111....22222", "2333133121414131402,00...111...2...333.44.5555.6666.777.888899"])
    fun `test GetDiskLayout`(input: String, expected: String) {
        val disk = Disk.fromDiskMap(input)

        assertThat(disk).hasToString(expected)
    }

    @Test
    fun `test freeUpSpaceMessy`() {
        val disk = Disk.fromDiskMap("2333133121414131402")
        val expected = Disk.fromString("0099811188827773336446555566..............")

        val freedUpDisk = disk.freeUpSpaceMessy()

        assertThat(freedUpDisk)
            .isEqualTo(expected)
            .has(checksum(1928))
    }

    @Test
    fun `test freeUp`() {
        val disk = Disk.fromDiskMap("2333133121414131402")
        val expected = Disk.fromString("00992111777.44.333....5555.6666.....8888..")

        runBlocking {
            val freedUpDisk = disk.freeUpSpace()
            assertThat(freedUpDisk)
                .isEqualTo(expected)
                .has(checksum(2858))
        }

    }

    private fun checksum(expected: Long): Condition<Disk> {
        var actual: Long = 0
        return Condition(
            { disk -> disk.checksum.also { actual = it } == expected },
            "checksum should be $expected, but was ${actual}"
        )
    }

    @Test
    fun `test checksum`() {
        val disk = Disk.fromString("00992111777.44.333....5555.6666.....8888..")

        val result = disk.checksum

        assertThat(result).isEqualTo(2858)
    }
}
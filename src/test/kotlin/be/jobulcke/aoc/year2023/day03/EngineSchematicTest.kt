package be.jobulcke.aoc.year2023.day03

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import kotlin.io.path.Path
import kotlin.io.path.readLines

class EngineSchematicTest {
    @Test
    fun given_SingleLineWithOnePartNumber_when_GetSumOfPartNumbers_then_ReturnSinglePartNumber() {
        val line = "617*......"
        val expectedPartNumber = 617
        val engineSchematic = EngineSchematic(listOf(line))

        val actualPartNumber = engineSchematic.partNumbers.sum()

        assertThat(actualPartNumber).isEqualTo(expectedPartNumber)
    }

    @ParameterizedTest
    @ValueSource(strings = ["617*..$55", "..617*55.", "..617+55.", "..617/55.", "$..617@55"])
    fun given_SingleLineWithTwoPartNumbers_when_GetSumOfPartNumbers_then_ReturnSum(line: String) {
        val expectedPartNumber = 672
        val engineSchematic = EngineSchematic(listOf(line))

        val actualPartNumber = engineSchematic.partNumbers.sum()

        assertThat(actualPartNumber).isEqualTo(expectedPartNumber)
    }

    @ParameterizedTest
    @ValueSource(strings = [".....+.58.", "...\$.*....", "467..114.."])
    fun given_SingleLineWithoutPartNumbers_when_GetSumOfPartNumbers_then_Return0(line: String) {
        val expectedPartNumber = 0
        val engineSchematic = EngineSchematic(listOf(line))

        val actualPartNumber = engineSchematic.partNumbers.sum()

        assertThat(actualPartNumber).isEqualTo(expectedPartNumber)
    }

    @Test
    fun given_SmallEngineSchematicLines_when_GetSumOfPartNumber_then_ReturnSum() {
        val expectedSum = 467 + 114
        val lines = listOf(
            ".....+.58.",
            "...$.*....",
            "467..114.."
        )
        val actualSum = EngineSchematic(lines).partNumbers.sum()

        assertThat(actualSum).isEqualTo(expectedSum)
    }

    @Test
    fun given_LargeEngineSchematicLines_when_GetSumOfPartNumber_then_ReturnSum() {
        val expectedSum = 4361
        val lines = javaClass.classLoader.getResource("2023/day3.txt")!!.readText().lines()
        val actualSum = EngineSchematic(lines).partNumbers.sum()

        assertThat(actualSum).isEqualTo(expectedSum)
    }

    @Test
    fun given_LargeEngineSchematicLines_when_GetGearsRatio_then_ReturnList() {
        val lines = javaClass.classLoader.getResource("2023/day3.txt")!!.readText().lines()
        val engine = EngineSchematic(lines)

        val gearRatios = engine.gearsRatios

        assertThat(gearRatios).containsExactlyInAnyOrder(16345, 451490)
    }
}
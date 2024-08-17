package be.jobulcke.aoc.day09

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class OasisHistoryTest {
    @Test
    fun test_GetSequences() {
        val expectedSequences = listOf(listOf(0, 3, 6, 9, 12, 15), listOf(3, 3, 3, 3, 3), listOf(0, 0, 0, 0))
        val history = OasisHistory(listOf(0, 3, 6, 9, 12, 15))

        val actualSequences = history.sequences

        assertThat(actualSequences).isEqualTo(expectedSequences)
    }

    @Test
    fun test_GetSequencesWithPrediction() {
        val expectedSequences = listOf(listOf(0, 3, 6, 9, 12, 15, 18), listOf(3, 3, 3, 3, 3, 3), listOf(0, 0, 0, 0, 0))
        val history = OasisHistory(listOf(0, 3, 6, 9, 12, 15))

        val actualSequences = history.sequencesWithPrediction

        assertThat(actualSequences).isEqualTo(expectedSequences)
    }

    @ParameterizedTest
    @MethodSource("results")
    fun test_GetResultPrediction(results: List<Int>, expectedPredication: Int) {
        val history = OasisHistory(results)

        assertThat(history.resultPrediction).isEqualTo(expectedPredication)
    }

    @Test
    fun test_GetSequencesWithBackwardsPrediction() {
        val expectedSequences = listOf(
            listOf(5, 10, 13, 16, 21, 30, 45),
            listOf(5, 3, 3, 5, 9, 15),
            listOf(-2, 0, 2, 4, 6),
            listOf(2, 2, 2, 2),
            listOf(0, 0, 0)
        )
        val history = OasisHistory(listOf(10, 13, 16, 21, 30, 45))

        val actualSequences = history.sequencesWithBackwardsPrediction

        assertThat(actualSequences).isEqualTo(expectedSequences)
    }

    @Test
    fun test_GetResultBackwardsPrediction() {
        val history = OasisHistory(listOf(10, 13, 16, 21, 30, 45))
        val backwardsPredication = 5

        assertThat(history.resultBackwardsPrediction).isEqualTo(backwardsPredication)
    }

    companion object {
        @JvmStatic
        fun results() = listOf(
            Arguments.of(listOf(0, 3, 6, 9, 12, 15), 18),
            Arguments.of(listOf(1, 3, 6, 10, 15, 21), 28),
            Arguments.of(listOf(10, 13, 16, 21, 30, 45), 68)
        )
    }
}
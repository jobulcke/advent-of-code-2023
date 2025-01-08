package be.jobulcke.aoc.year2023.day08

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import kotlin.io.path.Path
import kotlin.io.path.readLines

private const val directory = "src/test/resources/2023/day8"

class NetworkTest {
    @Test
    fun given_LongExample_when_GetSteps_then_Return2() {
        val network = Network.parse(Path("$directory/long-example.txt").readLines())

        val steps = network.stepsToEndNode

        assertThat(steps).isEqualTo(2)
    }

    @Test
    fun given_ShortExample_when_GetSteps_then_Return6() {
        val network = Network.parse(Path("$directory/short-example.txt").readLines())

        val steps = network.stepsToEndNode

        assertThat(steps).isEqualTo(6)
    }

    @Test
    fun test_GetStepsFromMultipleStartingNodes() {
        val network = Network.parse(Path("$directory/multiple-starting-nodes.txt").readLines())

        val steps = network.allStepsToEndNodes

        assertThat(steps).isEqualTo(6)
    }

    @Test
    fun test_Parsing() {
        val expectedNetwork = Network("LLR", listOf(
            Node("AAA", "BBB", "BBB"),
            Node("BBB", "AAA", "ZZZ"),
            Node("ZZZ", "ZZZ", "ZZZ"),
        ))

        val actualNetwork = Network.parse(Path("$directory/short-example.txt").readLines())

        assertThat(actualNetwork).isEqualTo(expectedNetwork)
    }
}
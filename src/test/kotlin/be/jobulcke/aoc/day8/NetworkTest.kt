package be.jobulcke.aoc.day8

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import kotlin.io.path.Path
import kotlin.io.path.readLines

class NetworkTest {
    @Test
    fun given_LongExample_when_GetSteps_then_Return2() {
        val network = Network.parse(Path("src/test/resources/day8/long-example.txt").readLines())

        val steps = network.getStepsToEndNode()

        assertThat(steps).isEqualTo(2)
    }

    @Test
    fun given_ShortExample_when_GetSteps_then_Return6() {
        val network = Network.parse(Path("src/test/resources/day8/short-example.txt").readLines())

        val steps = network.getStepsToEndNode()

        assertThat(steps).isEqualTo(6)
    }

    @Test
    fun test_Parsing() {
        val expectedNetwork = Network("LLR", listOf(
            Node("AAA", "BBB", "BBB"),
            Node("BBB", "AAA", "ZZZ"),
            Node("ZZZ", "ZZZ", "ZZZ"),
        ))

        val actualNetwork = Network.parse(Path("src/test/resources/day8/short-example.txt").readLines())

        assertThat(actualNetwork).isEqualTo(expectedNetwork)
    }
}
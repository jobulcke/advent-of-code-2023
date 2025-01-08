package be.jobulcke.aoc.year2023.day15

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class SequenceTest {
    @Test
    fun given_InvalidInput_when_FromString_then_ThrowException() {
        Assertions.assertThatThrownBy { Sequence.fromString("rs+3") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("Expected for input to contain one of the following chars: [=, -]")
    }

    @Test
    fun given_EqualsSignSequence_when_FromString_then_ReturnValidSequence() {
        val expectedSequence = Sequence("rs", EqualsSignOperationSign, 4)
        val input = "rs=4"

        val actualSequence = Sequence.fromString(input)

        Assertions.assertThat(actualSequence).isEqualTo(expectedSequence)
    }

    @Test
    fun given_DashSequence_when_FromString_then_ReturnValidSequence() {
        val expectedSequence = Sequence("rs", DashOperationSign)
        val input = "rs-"

        val actualSequence = Sequence.fromString(input)

        Assertions.assertThat(actualSequence).isEqualTo(expectedSequence)
    }
}
package be.jobulcke.aoc.day15

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class SequenceTest {
    @Test
    fun given_InvalidInput_when_FromString_then_ThrowException() {
        assertThatThrownBy { Sequence.fromString("rs+3") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("Expected for input to contain one of the following chars: [=, -]")
    }

    @Test
    fun given_EqualsSignSequence_when_FromString_then_ReturnValidSequence() {
        val expectedSequence = Sequence("rs", EqualsSignOperationSign, 4)
        val input = "rs=4"

        val actualSequence = Sequence.fromString(input)

        assertThat(actualSequence).isEqualTo(expectedSequence)
    }

    @Test
    fun given_DashSequence_when_FromString_then_ReturnValidSequence() {
        val expectedSequence = Sequence("rs", DashOperationSign)
        val input = "rs-"

        val actualSequence = Sequence.fromString(input)

        assertThat(actualSequence).isEqualTo(expectedSequence)
    }
}
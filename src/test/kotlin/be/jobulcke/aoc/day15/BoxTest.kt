package be.jobulcke.aoc.day15

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.util.function.Consumer
import java.util.function.Function

class BoxTest {
    @Test
    fun given_BoxWithSequences_when_AddSequenceWithSameLabel_then_ReplaceLabel() {
        val box = Box(1).apply {
            handleSequence(Sequence("rs", EqualsSignOperationSign, 3))
            handleSequence(Sequence("cp", EqualsSignOperationSign, 1))
        }

        box.handleSequence(Sequence("rs", EqualsSignOperationSign, 5))

        assertThat(box.slots)
            .containsExactly(SequenceSlot("rs", 5), SequenceSlot("cp", 1))
            .first()
            .extracting(SequenceSlot::focalLength)
            .isEqualTo(5)
    }

    @Test
    fun given_BoxWithSequences_when_RemoveSequence_then_ExpectSlotNumbersToBeChanged() {
        val box = Box(1).apply {
            handleSequence(Sequence("rs", EqualsSignOperationSign, 3))
            handleSequence(Sequence("cp", EqualsSignOperationSign, 1))
            handleSequence(Sequence("qv", EqualsSignOperationSign, 2))
        }

        box.handleSequence(Sequence("cp", DashOperationSign))

        assertThat(box.slots)
            .containsExactly(SequenceSlot("rs", 3), SequenceSlot("qv", 2))
            .satisfies(Consumer {
                assertThat(it.indexOf(SequenceSlot("rs", 3))).isEqualTo(0)
                assertThat(it.indexOf(SequenceSlot("qv", 2))).isEqualTo(1)
            })
    }

    @Test
    fun test_GetFocussingPower() {
        val box = Box(0).apply {
            handleSequence(Sequence("rn", EqualsSignOperationSign, 1))
            handleSequence(Sequence("cm", EqualsSignOperationSign, 2))
        }

        val focussingPower = box.focussingPower

        assertThat(focussingPower).isEqualTo(5)
    }
}
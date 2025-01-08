package be.jobulcke.aoc.year2023.day15

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class InitializationSequenceTest {
    @Test
    fun test_HolidayAsciiHash() {
        val initializationSequence = InitializationSequence(SEQUENCE)

        val hash = initializationSequence.holidayAsciiHash

        Assertions.assertThat(hash).isEqualTo(1320)
    }

    @Test
    fun test_FocussingPower() {
        val initializationSequence = InitializationSequence(SEQUENCE)

        val focussingPower = initializationSequence.focussingPower

        Assertions.assertThat(focussingPower).isEqualTo(145)
    }

    companion object {
        private const val SEQUENCE = "rn=1,cm-,qp=3,cm=2,qp-,pc=4,ot=9,ab=5,pc-,pc=6,ot=7"
    }
}
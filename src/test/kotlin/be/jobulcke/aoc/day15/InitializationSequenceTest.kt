package be.jobulcke.aoc.day15

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class InitializationSequenceTest {
    @Test
    fun test_HolidayAsciiHash() {
        val initializationSequence = InitializationSequence("rn=1,cm-,qp=3,cm=2,qp-,pc=4,ot=9,ab=5,pc-,pc=6,ot=7")

        val hash = initializationSequence.holidayAsciiHash

        assertThat(hash).isEqualTo(1320)
    }
}
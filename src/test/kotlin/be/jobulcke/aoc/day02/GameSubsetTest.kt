package be.jobulcke.aoc.day02

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class GameSubsetTest {
    @Test
    fun test_FromStringConstruction() {
        val line = "1 red, 2 green, 6 blue"
        val expectedGameSubset = GameSubset(1, 2, 6)

        val constructedGameSubset = GameSubset.fromString(line)

        assertThat(constructedGameSubset).isEqualTo(expectedGameSubset)
    }

    @Test
    fun given_PossibleGame_when_checkPossibility_then_ReturnTrue() {
        val gameSubset = GameSubset.fromString("5 blue, 4 red, 13 green")

        val isPossible = gameSubset.isPossibleWith(12, 13, 14)

        assertThat(isPossible).isTrue()
    }

    @Test
    fun given_ImpossibleGame_when_checkPossibility_then_ReturnFalse() {
        val gameSubset = GameSubset.fromString("8 green, 6 blue, 20 red")

        val isPossible = gameSubset.isPossibleWith(12, 13, 14)

        assertThat(isPossible).isFalse()
    }
}
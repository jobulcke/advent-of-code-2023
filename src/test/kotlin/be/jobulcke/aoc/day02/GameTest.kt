package be.jobulcke.aoc.day02

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.groups.Tuple
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import kotlin.io.path.Path
import kotlin.io.path.readLines

class GameTest {
    @Test
    fun `test fromString construction`() {
        val line = "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green"
        val expectedGame = Game(
            1, listOf(
                GameSubset(4, 0, 3),
                GameSubset(1, 2, 6),
                GameSubset(0, 2, 0)
            )
        )

        val fromStringConstructedGame = Game.fromString(line)

        assertThat(fromStringConstructedGame).isEqualTo(expectedGame)
    }

    @Test
    fun given_listOfGames_when_checkedIfPossible_then_ReturnFilteredList() {
        val (red, green, blue) = listOf(12, 13, 14)

        val possibleGames = initGames()
            .filter { it.isPossibleWith(red, green, blue) }

        assertThat(possibleGames).map(Game::id)
            .containsExactlyInAnyOrder(Tuple(1), Tuple(2), Tuple(5))
    }

    @ParameterizedTest
    @MethodSource("gamesWithFewestPossible")
    fun given_Game_when_getFewestPossibleCubes_then_ReturnMap(game: Game, expectedFewestPossibleCubes: Map<CubeColor, Int>) {
        val actualFewestPossibleCubes = game.fewestPossibleCubes

        assertThat(actualFewestPossibleCubes).isEqualTo(expectedFewestPossibleCubes)
    }

    @ParameterizedTest
    @MethodSource("gamesWithPower")
    fun given_Game_when_getPower_then_ReturnInt(game: Game, expectedPower: Int) {
        assertThat(game.power).isEqualTo(expectedPower)
    }

    @Test
    fun given_ListOfGame_when_getSumOfPowers_then_ReturnInteger() {
        val sum = initGames().sumOf(Game::power)

        assertThat(sum).isEqualTo(2286)
    }

    companion object {
        private fun initGames() = Path("src/test/resources/day2.txt").readLines().map { Game.fromString(it) }

        @JvmStatic
        fun gamesWithFewestPossible(): List<Arguments> {
            val gameIdsWithFewestCubes = mapOf(
                1 to mapOf(CubeColor.Red to 4, CubeColor.Green to 2, CubeColor.Blue to 6),
                2 to mapOf(CubeColor.Red to 1, CubeColor.Green to 3, CubeColor.Blue to 4),
                3 to mapOf(CubeColor.Red to 20, CubeColor.Green to 13, CubeColor.Blue to 6),
                4 to mapOf(CubeColor.Red to 14, CubeColor.Green to 3, CubeColor.Blue to 15),
                5 to mapOf(CubeColor.Red to 6, CubeColor.Green to 3, CubeColor.Blue to 2)
            )
            return initGames().map { Arguments.of(it, gameIdsWithFewestCubes[it.id]) }
        }

        // game 1 is 48. In games 2-5 it was 12, 1560, 630, and 36
        @JvmStatic
        fun gamesWithPower(): List<Arguments> {
            val gamesWithPower = mapOf(
                1 to 48,
                2 to 12,
                3 to 1560,
                4 to 630,
                5 to 36
            )
            return initGames().map { Arguments.of(it, gamesWithPower[it.id]) }
        }
    }
}
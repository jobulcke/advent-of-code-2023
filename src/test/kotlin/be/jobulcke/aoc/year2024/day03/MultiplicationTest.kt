package be.jobulcke.aoc.year2024.day03

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestFactory
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class MultiplicationTest {

    @Test
    fun `given simpleMultiplicationText test readMultiplications`() {
        val input = "mul(4,6)"

        val result = Multiplication.parse(input)

        assertThat(result).isEqualTo(Multiplication(4, 6))
    }

    @TestFactory
    fun `given MultiplicationText test parseMultiplication`() = listOf(
        "mul(4,6)" to Multiplication(4, 6),
        "mul(44,66)" to Multiplication(44, 66),
        "mul(123,4)" to Multiplication(123, 4),
    ).map { (input, expected) ->
        DynamicTest.dynamicTest("given $input test parseMultiplication") {
            val result = Multiplication.parse(input)
            assertThat(result).isEqualTo(expected)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["mul(4,6,7)", "mul(1234,5)", "mul(1234.5,6)", "mul(4*", "mul(6,9!", "?(12,34)", "mul( 2 , 4 )"])
    fun `given invalidMultiplicationText test parseMultiplication`(input: String) {
        assertThatThrownBy { Multiplication.parse(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("Invalid input: $input")
    }


}
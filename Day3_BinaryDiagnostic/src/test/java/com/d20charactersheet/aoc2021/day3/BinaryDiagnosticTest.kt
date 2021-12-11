package com.d20charactersheet.aoc2021.day3

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BinaryDiagnosticTest {

    @Test
    fun loadBinaryReport() {
        // act
        val rawData =
            BinaryDiagnostic().loadRawData(".\\src\\test\\resources\\binary_diagnostic_test.txt")

        // assert
        assertThat(rawData.numbers).containsExactly(
            0b00100,
            0b11110,
            0b10110,
            0b10111,
            0b10101,
            0b01111,
            0b00111,
            0b11100,
            0b10000,
            0b11001,
            0b00010,
            0b01010
        )

    }

    @Test
    fun readGammaRate() {
        // arrange
        val numbers = listOf(
            0b00100,
            0b11110,
            0b10110,
            0b10111,
            0b10101,
            0b01111,
            0b00111,
            0b11100,
            0b10000,
            0b11001,
            0b00010,
            0b01010
        )

        val rawData = RawData(numbers, 5)

        // act
        val gammaRate = BinaryDiagnostic().readGammaRate(rawData)

        // assert
        assertThat(gammaRate).isEqualTo(22)
    }

    @Test
    fun createEpsilonRate() {
        // act
        val epsilonRate = BinaryDiagnostic().createEpsilonRate(22, 5)

        // assert
        assertThat(epsilonRate).isEqualTo(9)
    }

    @Test
    fun getMask_position0_return1() {
        // act
        val result = BinaryDiagnostic().getMask(0)

        // assert
        assertThat(result).isEqualTo(1)
    }

    @Test
    fun getMask_position1_return2() {
        // act
        val result = BinaryDiagnostic().getMask(1)

        // assert
        assertThat(result).isEqualTo(2)
    }

    @Test
    fun getMask_position2_return4() {
        // act
        val result = BinaryDiagnostic().getMask(2)

        // assert
        assertThat(result).isEqualTo(4)
    }

}
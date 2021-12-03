package com.d20charactersheet.aoc2021.day3

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BinaryDiagnosticTest {

    @Test
    fun readGammaRate() {
        // arrange
        val diagnosticReport = listOf(
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

        // act
        val gammaRate = BinaryDiagnostic().readGammaRate(diagnosticReport)

        // assert
        assertThat(gammaRate).isEqualTo(22)
    }

    @Test
    fun createEpsilonRate() {
        // arrange

        // act
        val epsilonRate = BinaryDiagnostic().createEpsilonRate(22)

        // assert
        assertThat(epsilonRate).isEqualTo(9)
    }

}
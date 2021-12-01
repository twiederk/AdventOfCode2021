package com.d20charactersheet.aoc2021.day1


import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SonarSweepTest {

    @Test
    fun loadSonarSweepReport() {

        // act
        val data = SonarSweep().loadSonarSweepReport(".\\src\\test\\resources\\sonar_sweep_report_test.txt")

        // assert
        assertThat(data).hasSize(10)
    }

    @Test
    fun count_increase_depth() {
        // arrange
        val data: List<Int> = listOf(
            199,
            200,
            208,
            210,
            200,
            207,
            240,
            269,
            260,
            263
        )

        // act
        val numberOfDepthIncreases = SonarSweep().countDepthIncreases(data)

        // assert
        assertThat(numberOfDepthIncreases).isEqualTo(7)
    }

}
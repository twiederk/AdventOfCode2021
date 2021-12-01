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

}
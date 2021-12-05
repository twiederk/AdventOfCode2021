package com.d20charactersheet.aoc2021.day3

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BingoLoaderTest {

    @Test
    fun loadNumbersToDraw() {
        // arrange

        // act
        val numbersToDraw = BingoLoader().loadNumbersToDraw(".\\src\\test\\resources\\bingo_test.txt")

        // assert
        assertThat(numbersToDraw).hasSize(27)
    }

}
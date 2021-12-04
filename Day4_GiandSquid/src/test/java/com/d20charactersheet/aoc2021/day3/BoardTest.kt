package com.d20charactersheet.aoc2021.day3

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BoardTest {

    @Test
    fun init() {
        // arrange

        // act
        val board = Board(
            arrayOf(
                intArrayOf(14, 21, 17, 24, 4),
                intArrayOf(10, 16, 15, 9, 19),
                intArrayOf(18, 8, 23, 26, 20),
                intArrayOf(22, 11, 13, 6, 5),
                intArrayOf(2, 0, 12, 3, 7)
            )
        )

        // assert
        assertThat(board.lanes).containsExactly(
            intArrayOf(14, 21, 17, 24, 4),
            intArrayOf(10, 16, 15, 9, 19),
            intArrayOf(18, 8, 23, 26, 20),
            intArrayOf(22, 11, 13, 6, 5),
            intArrayOf(2, 0, 12, 3, 7),

            intArrayOf(14, 10, 18, 22, 2),
            intArrayOf(21, 16, 8, 11, 0),
            intArrayOf(17, 15, 23, 13, 12),
            intArrayOf(24, 9, 26, 6, 3),
            intArrayOf(4, 19, 20, 5, 7)
        )
    }

}
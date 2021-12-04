package com.d20charactersheet.aoc2021.day3

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BoardTest {

    @Test
    fun init() {
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
            listOf(14, 21, 17, 24, 4),
            listOf(10, 16, 15, 9, 19),
            listOf(18, 8, 23, 26, 20),
            listOf(22, 11, 13, 6, 5),
            listOf(2, 0, 12, 3, 7),

            listOf(14, 10, 18, 22, 2),
            listOf(21, 16, 8, 11, 0),
            listOf(17, 15, 23, 13, 12),
            listOf(24, 9, 26, 6, 3),
            listOf(4, 19, 20, 5, 7)
        )
        assertThat(board.allNumbers).hasSize(25)
    }

    @Test
    fun movesToWinLane() {
        // arrange
        val drawnNumbers =
            listOf(7, 4, 9, 5, 11, 17, 23, 2, 0, 14, 21, 24, 10, 16, 13, 6, 15, 25, 12, 22, 18, 20, 8, 19, 3, 26, 1)
        val board = Board(
            arrayOf(
                intArrayOf(14, 21, 17, 24, 4),
                intArrayOf(10, 16, 15, 9, 19),
                intArrayOf(18, 8, 23, 26, 20),
                intArrayOf(22, 11, 13, 6, 5),
                intArrayOf(2, 0, 12, 3, 7)
            )
        )

        // act
        val movesToWin = board.movesToWinLane(board.lanes[0], drawnNumbers)

        // assert
        assertThat(movesToWin).isEqualTo(12)
    }

    @Test
    fun movesToWinBoard() {
        // arrange
        val numbersToDraw =
            listOf(7, 4, 9, 5, 11, 17, 23, 2, 0, 14, 21, 24, 10, 16, 13, 6, 15, 25, 12, 22, 18, 20, 8, 19, 3, 26, 1)
        val board = Board(
            arrayOf(
                intArrayOf(14, 21, 17, 24, 4),
                intArrayOf(10, 16, 15, 9, 19),
                intArrayOf(18, 8, 23, 26, 20),
                intArrayOf(22, 11, 13, 6, 5),
                intArrayOf(2, 0, 12, 3, 7)
            )
        )

        // act
        val movesToWin = board.movesToWinBoard(numbersToDraw)

        // assert
        assertThat(movesToWin).isEqualTo(12)

    }
}
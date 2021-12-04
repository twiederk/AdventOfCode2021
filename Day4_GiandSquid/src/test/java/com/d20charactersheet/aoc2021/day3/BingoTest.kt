package com.d20charactersheet.aoc2021.day3

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BingoTest {

    @Test
    fun getWinnerBoard() {
        // arrange
        val bingo = Bingo()
        val firstBoard = Board(
            listOf(
                listOf(14, 21, 17, 24, 4),
                listOf(10, 16, 15, 9, 19),
                listOf(18, 8, 23, 26, 20),
                listOf(22, 11, 13, 6, 5),
                listOf(2, 0, 12, 3, 7)
            )
        )
        val secondBoard = Board(
            listOf(
                listOf(3, 15, 0, 2, 22),
                listOf(9, 18, 13, 17, 5),
                listOf(19, 8, 7, 25, 23),
                listOf(20, 11, 10, 24, 4),
                listOf(14, 21, 16, 12, 6),
            )
        )
        val thirdBoard = Board(
            listOf(
                listOf(14, 21, 17, 24, 4),
                listOf(10, 16, 15, 9, 19),
                listOf(18, 8, 23, 26, 20),
                listOf(22, 11, 13, 6, 5),
                listOf(2, 0, 12, 3, 7),
            )
        )


        bingo.addBoard(firstBoard)
        bingo.addBoard(secondBoard)
        bingo.addBoard(thirdBoard)

        val numbersToDraw =
            listOf(7, 4, 9, 5, 11, 17, 23, 2, 0, 14, 21, 24, 10, 16, 13, 6, 15, 25, 12, 22, 18, 20, 8, 19, 3, 26, 1)

        // act
        val winnerBoard = bingo.getWinnerBoard(numbersToDraw)

        // assert
        assertThat(winnerBoard).isEqualTo(thirdBoard)
    }

    @Test
    fun score() {
        // arrange
        val board = Board(
            listOf(
                listOf(14, 21, 17, 24, 4),
                listOf(10, 16, 15, 9, 19),
                listOf(18, 8, 23, 26, 20),
                listOf(22, 11, 13, 6, 5),
                listOf(2, 0, 12, 3, 7),
            )
        )
        val numbersToDraw =
            listOf(7, 4, 9, 5, 11, 17, 23, 2, 0, 14, 21, 24, 10, 16, 13, 6, 15, 25, 12, 22, 18, 20, 8, 19, 3, 26, 1)
        board.movesToWinBoard(numbersToDraw)

        // act
        val score = Bingo().score(numbersToDraw, board)

        // assert
        assertThat(score).isEqualTo(4512)
    }

}
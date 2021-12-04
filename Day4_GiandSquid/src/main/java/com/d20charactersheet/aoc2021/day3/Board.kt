package com.d20charactersheet.aoc2021.day3

class Board(board: Array<IntArray>) {

    val lanes: MutableList<IntArray> = mutableListOf()
    val allNumbers : MutableList<Int> = mutableListOf()

    init {
        for (row in board) {
            lanes.add(row)
        }
        lanes.addAll(createColumns(board))

        for (row in board) {
            for (number in row)
            allNumbers.add(number)
        }
    }

    private fun createColumns(board: Array<IntArray>): List<IntArray> {
        val columns: MutableList<IntArray> = mutableListOf()
        for (column in 0..4) {
            columns.add(
                intArrayOf(
                    board[0][column],
                    board[1][column],
                    board[2][column],
                    board[3][column],
                    board[4][column]
                )
            )
        }
        return columns
    }
}

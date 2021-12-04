package com.d20charactersheet.aoc2021.day3

class Board(board: List<List<Int>>) {

    val lanes: MutableList<List<Int>> = mutableListOf()
    val allNumbers: MutableList<Int> = mutableListOf()
    var movesToWin: Int = 1000
        private set

    init {
        for (row in board) {
            lanes.add(mutableListOf(*row.toTypedArray()))
        }
        lanes.addAll(createColumns(board))

        for (row in board) {
            for (number in row)
                allNumbers.add(number)
        }
    }

    private fun createColumns(board: List<List<Int>>): List<List<Int>> {
        val columns: MutableList<List<Int>> = mutableListOf()
        for (column in 0..4) {
            columns.add(
                listOf(
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

    fun movesToWinLane(lane: List<Int>, numbersToDraw: List<Int>): Int {
        val tempLane = lane.toMutableList()
        var movesToWin = 0

        for (drawnNumber in numbersToDraw) {
            movesToWin++
            tempLane.remove(drawnNumber)
            if (tempLane.isEmpty()) {
                break
            }
        }
        return movesToWin
    }

    fun movesToWinBoard(numbersToDraw: List<Int>): Int {
        var movesToWin = 1000
        for (lane in lanes) {
            if (movesToWin > movesToWinLane(lane, numbersToDraw)) {
                movesToWin = movesToWinLane(lane, numbersToDraw)
            }
        }
        this.movesToWin = movesToWin
        return movesToWin
    }

}

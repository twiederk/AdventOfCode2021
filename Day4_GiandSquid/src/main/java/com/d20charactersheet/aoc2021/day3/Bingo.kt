package com.d20charactersheet.aoc2021.day3

class Bingo {

    val boards: MutableList<Board> = mutableListOf()

    fun addBoard(board: Board) {
        boards.add(board)
    }

    fun getWinnerBoard(numbersToDraw: List<Int>): Board {
        var winnerBoard = boards[0]
        val movesToWin = 1000
        for (board in boards) {
            if (board.movesToWinBoard(numbersToDraw) < movesToWin) {
                winnerBoard = board
            }
        }
        return winnerBoard
    }

}

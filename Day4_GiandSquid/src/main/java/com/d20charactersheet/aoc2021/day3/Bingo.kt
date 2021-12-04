package com.d20charactersheet.aoc2021.day3

class Bingo {

    private val boards: MutableList<Board> = mutableListOf()

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

    fun score(numbersToDraw: List<Int>, board: Board): Int {
        val numbersDrawn = numbersToDraw.slice(IntRange(0, board.movesToWin - 1))
        val unmarkedNumbers = board.allNumbers.toMutableList()
        unmarkedNumbers.removeAll(numbersDrawn)
        return unmarkedNumbers.sum() * numbersDrawn.last()
    }

}

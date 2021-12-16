package com.d20charactersheet.aoc2021.day3

fun main(args: Array<String>) {

    val numbersToDraw = BingoLoader().loadNumbersToDraw(args[0])
    val boards = BingoLoader().loadBoards(args[0])

    val bingo = Bingo()
    for (board in boards) {
        bingo.addBoard(board)
    }
    val winnerBoard = bingo.getWinnerBoard(numbersToDraw)
    val score = bingo.score(numbersToDraw, winnerBoard)
    println("score of winnerBoard: $score")
}
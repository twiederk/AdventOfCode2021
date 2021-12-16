package com.d20charactersheet.aoc2021.day3

import kotlin.io.path.Path
import kotlin.io.path.readLines

class BingoLoader {

    fun loadNumbersToDraw(filename: String): List<Int> {
        val lines = Path(filename).readLines()
        return lines[0].split(',').map { it.toInt() }
    }

    fun loadBoards(filename: String): List<Board> {
        val lines = Path(filename).readLines()
        val boardsRawData: List<List<String>> = lines.drop(1).chunked(6)

        val boards = mutableListOf<Board>()
        for (boardRawData: List<String> in boardsRawData) {
            val boardRawDataWithoutFirstLine = boardRawData.drop(1)
            val boardConvertedRawData = boardRawDataWithoutFirstLine.map { line ->
                line.trim()
                    .split(Regex("\\W+"))
                    .map { it.toInt() }
            }
            boards.add(Board(boardConvertedRawData))
        }

        return boards
    }

}

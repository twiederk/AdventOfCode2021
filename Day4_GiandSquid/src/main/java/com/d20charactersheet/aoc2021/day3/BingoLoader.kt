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
        val range = IntRange(2, lines.size - 5)
        val boards = mutableListOf<Board>()
        for (lineIndex in range step 5) {
            val data = listOf(
                lines[lineIndex].trim().replace("  ", " ").split(' ').map { it.trim().toInt() },
                lines[lineIndex + 1].trim().replace("  ", " ").split(' ').map { it.trim().toInt() },
                lines[lineIndex + 2].trim().replace("  ", " ").split(' ').map { it.trim().toInt() },
                lines[lineIndex + 3].trim().replace("  ", " ").split(' ').map { it.trim().toInt() },
                lines[lineIndex + 4].trim().replace("  ", " ").split(' ').map { it.trim().toInt() },
            )
            boards.add(Board(data))
        }

        return boards
    }

}

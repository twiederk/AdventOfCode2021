package com.d20charactersheet.aoc2021.day3

import kotlin.io.path.Path
import kotlin.io.path.readLines

class BingoLoader {

    fun loadNumbersToDraw(filename: String): List<Int> {
        val lines = Path(filename).readLines()
        return lines[0].split(',').map { it.toInt() }
    }

}

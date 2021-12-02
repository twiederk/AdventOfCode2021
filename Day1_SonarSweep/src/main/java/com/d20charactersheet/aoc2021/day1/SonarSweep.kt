package com.d20charactersheet.aoc2021.day1

import kotlin.io.path.Path
import kotlin.io.path.readLines

class SonarSweep {

    private companion object {
        const val DEPTH_ZERO = 0
    }

    fun loadSonarSweepReport(filename: String): List<Int> {
        return Path(filename).readLines().map { it.toInt() }
    }

    fun countDepthIncreases(data: List<Int>): Int {
        var lastValue = DEPTH_ZERO
        var countDepthIncrease = 0
        for (depth in data) {
            if (lastValue != DEPTH_ZERO && depth > lastValue) {
                countDepthIncrease++
            }
            lastValue = depth
        }
        return countDepthIncrease
    }

    fun sumSlidingWindows(data: List<Int>): List<Int> {
        val sums = mutableListOf<Int>()
        for (index in 0..data.size - 3) {
            val range = IntRange(index, index + 2)
            sums.add(data.slice(range).sum())
        }
        return sums.toList()
    }

}

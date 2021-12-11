package com.d20charactersheet.aoc2021.day3

import kotlin.io.path.Path
import kotlin.io.path.readLines

class BinaryDiagnostic {

    fun readGammaRate(rawData: RawData): Int {
        val counter = mutableMapOf<Int, Int>()
        for (number in rawData.numbers) {
            for (column in IntRange(0, rawData.numberOfColumns - 1)) {
                if (number and getMask(column) > 0) increaseCounter(column, counter)
            }
        }
        return buildGamaRate(rawData, counter)
    }

    private fun increaseCounter(column: Int, counter: MutableMap<Int, Int>) {
        val count = counter.getOrDefault(column, 0)
        counter[column] = count + 1
    }

    fun getMask(column: Int): Int {
        return 0b1 shl column
    }

    private fun buildGamaRate(rawData: RawData, counter: MutableMap<Int, Int>): Int {
        var gammaRate = 0
        for (column in IntRange(0, rawData.numberOfColumns - 1)) {
            val numberOfOnesInColumn = counter.getOrDefault(column, 0)
            if (numberOfOnesInColumn > rawData.numbers.size / 2) {
                gammaRate += getMask(column)
            }
        }
        return gammaRate
    }

    fun createEpsilonRate(gammaRate: Int, numberOfDigits: Int): Int {
        return gammaRate.inv() and getFullMask(numberOfDigits)
    }

    private fun getFullMask(numberOfDigits: Int): Int {
        var fullMask = 0
        for (position in IntRange(0, numberOfDigits - 1)) {
            fullMask += getMask(position)
        }
        return fullMask
    }

    fun loadRawData(filename: String): RawData {
        val numbersAsStrings = Path(filename).readLines()
        val numbers = numbersAsStrings.map { Integer.parseInt(it, 2); }
        val numberOfColumns = numbersAsStrings[0].length
        return RawData(numbers, numberOfColumns)
    }

}
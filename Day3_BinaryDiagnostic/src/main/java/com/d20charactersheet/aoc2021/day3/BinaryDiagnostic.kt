package com.d20charactersheet.aoc2021.day3

class BinaryDiagnostic {

    fun readGammaRate(diagnosticReport: List<Int>): Int {
        var counter5 = 0
        var counter4 = 0
        var counter3 = 0
        var counter2 = 0
        var counter1 = 0
        for (number in diagnosticReport) {
            if (number and 0b00001 > 0) counter1++
            if (number and 0b00010 > 0) counter2++
            if (number and 0b00100 > 0) counter3++
            if (number and 0b01000 > 0) counter4++
            if (number and 0b10000 > 0) counter5++
        }
        return buildGamaRate(diagnosticReport.size / 2, counter1, counter2, counter3, counter4, counter5)
    }

    private fun buildGamaRate(
        halfNumberOfReport: Int,
        counter1: Int,
        counter2: Int,
        counter3: Int,
        counter4: Int,
        counter5: Int
    ): Int {
        var gammaRate = 0
        if (counter1 > halfNumberOfReport) gammaRate += 0b00001
        if (counter2 > halfNumberOfReport) gammaRate += 0b00010
        if (counter3 > halfNumberOfReport) gammaRate += 0b00100
        if (counter4 > halfNumberOfReport) gammaRate += 0b01000
        if (counter5 > halfNumberOfReport) gammaRate += 0b10000
        return gammaRate
    }

    fun createEpsilonRate(gammaRate: Int): Int {
        return gammaRate.inv() and 0b11111
    }

}

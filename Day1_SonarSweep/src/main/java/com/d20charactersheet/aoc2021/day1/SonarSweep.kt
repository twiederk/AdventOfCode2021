package com.d20charactersheet.aoc2021.day1

import kotlin.io.path.Path
import kotlin.io.path.readLines

class SonarSweep {

    fun loadSonarSweepReport(filename: String): List<String> {
        return Path(filename).readLines()
    }

}

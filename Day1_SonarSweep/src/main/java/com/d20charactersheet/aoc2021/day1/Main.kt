package com.d20charactersheet.aoc2021.day1

fun main(args: Array<String>) {
    val sonarSweep = SonarSweep()
    val sonarSweepReport = sonarSweep.loadSonarSweepReport(args[0])
    val slidingWindowReport = sonarSweep.sumSlidingWindows(sonarSweepReport)
    val numberOfDepthIncreases = sonarSweep.countDepthIncreases(slidingWindowReport)
    println("numberOfDepthIncreases = $numberOfDepthIncreases")
}
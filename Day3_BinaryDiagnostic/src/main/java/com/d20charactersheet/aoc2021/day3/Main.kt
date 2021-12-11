package com.d20charactersheet.aoc2021.day3

fun main(args: Array<String>) {

    val binaryDiagnostic = BinaryDiagnostic()
    val report = binaryDiagnostic.loadRawData(args[0])
    val gammaRate = binaryDiagnostic.readGammaRate(report)
    val epsilonRate = binaryDiagnostic.createEpsilonRate(gammaRate)
    val powerConsumption = gammaRate * epsilonRate

    println("powerConsumption = $powerConsumption")
}
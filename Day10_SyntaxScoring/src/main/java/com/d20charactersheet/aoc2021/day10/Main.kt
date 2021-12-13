package com.d20charactersheet.aoc2021.day10

fun main(args: Array<String>) {
    val syntaxScoring = SyntaxScoring()
    val program = syntaxScoring.loadProgramm(args[0])
    val score = syntaxScoring.checkAutocomplete(program)
    println("score: $score")
}

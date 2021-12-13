package com.d20charactersheet.aoc2021.day10

import java.util.*
import kotlin.io.path.Path
import kotlin.io.path.readLines

class SyntaxScoring {

    private val openBrackets : List<Char> = listOf('(', '{', '[', '<')

    fun checkSyntax(input: String): Int {
        val programStack = Stack<Char>()
        for (programPointer in IntRange(0, input.length - 1)) {
            val statement = input[programPointer]
            if (openBrackets.contains(statement)) {
                programStack.push(statement)
                continue
            }
            val popStatement = programStack.pop()
            if (statement == ')' && popStatement == '(') continue
            if (statement == '}' && popStatement == '{') continue
            if (statement == ']' && popStatement == '[') continue
            if (statement == '>' && popStatement == '<') continue
            return calculateScore(statement)
        }

        return 0
    }

    private fun calculateScore(statement: Char): Int {
        when (statement) {
            ')' -> return 3
            ']' -> return 57
            '}' -> return 1197
            '>' -> return 25137
        }
        throw IllegalArgumentException("unknown statement: $statement")
    }

    fun checkProgram(program: List<String>): Int {
        var score = 0
        for (line in program) {
            score += checkSyntax(line)
        }
        return score
    }

    fun loadProgramm(filename: String): List<String> {
        return Path(filename).readLines()
    }

}


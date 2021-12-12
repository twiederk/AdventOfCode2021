package com.d20charactersheet.aoc2021.day10

import java.util.*

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

}


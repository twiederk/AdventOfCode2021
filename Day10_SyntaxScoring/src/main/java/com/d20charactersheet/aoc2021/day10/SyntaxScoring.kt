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
            return 0
        }
        if (programStack.isNotEmpty()) {
            return calculateAutocompleteScore(programStack)
        }
        return 0
    }

    private fun calculateAutocompleteScore(programStack : Stack<Char>): Int {
        var totalScore = 0
        while (programStack.isNotEmpty()) {
            totalScore *= 5
            totalScore += getCloseBracketScore(programStack.pop())
        }
        return totalScore
    }

    private fun getCloseBracketScore(statement: Char?): Int {
        when (statement) {
            '(' -> return 1
            '[' -> return 2
            '{' -> return 3
            '<' -> return 4
        }
        throw IllegalArgumentException("unknown statement: $statement")
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

    fun checkAutocomplete(program: List<String>): Int {
        val scores = mutableListOf<Int>()
        for (line in program) {
            val score = checkSyntax(line)
            if (score > 0) {
                scores.add(score)
            }
        }
        scores.sort()
        println(scores)
        return scores[scores.size / 2]
    }

}


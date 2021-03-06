package com.d20charactersheet.aoc2021.day10

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SyntaxScoringTest {

    @Test
    fun checkSyntax_RoundBrackets() {
        // act
        val score = SyntaxScoring().checkSyntax("()")

        // assert
        assertThat(score).isEqualTo(0)
    }

    @Test
    fun checkSyntax_CurleyBrackets() {
        // act
        val score = SyntaxScoring().checkSyntax("{}")

        // assert
        assertThat(score).isEqualTo(0)
    }

    @Test
    fun checkSyntax_SquareBrackets() {
        // act
        val score = SyntaxScoring().checkSyntax("[]")

        // assert
        assertThat(score).isEqualTo(0)
    }

    @Test
    fun checkSyntax_AngleBrackets() {
        // act
        val score = SyntaxScoring().checkSyntax("<>")

        // assert
        assertThat(score).isEqualTo(0)
    }

    @Test
    fun checkSyntax_CorruptedLine_score57() {
        // act
        val score = SyntaxScoring().checkSyntax("(]")

        // assert
        assertThat(score).isEqualTo(57)
    }

    @Test
    fun checkSyntax_CorruptedLine_score25137() {
        // act
        val score = SyntaxScoring().checkSyntax("{()()()>")

        // assert
        assertThat(score).isEqualTo(25137)
    }

    @Test
    fun checkSyntax_CorruptedLine_score1197() {
        // act
        val score = SyntaxScoring().checkSyntax("(((()))}")

        // assert
        assertThat(score).isEqualTo(1197)
    }

    @Test
    fun checkSyntax_CorruptedLine_score3() {
        // act
        val score = SyntaxScoring().checkSyntax("<([]){()}[{}])")

        // assert
        assertThat(score).isEqualTo(3)
    }

    @Test
    fun checkProgram() {
        // arrange
        val program = listOf(
            "[({(<(())[]>[[{[]{<()<>>",
            "[(()[<>])]({[<{<<[]>>(",
            "{([(<{}[<>[]}>{[]{[(<()>",
            "(((({<>}<{<{<>}{[]{[]{}",
            "[[<[([]))<([[{}[[()]]]",
            "[{[{({}]{}}([{[{{{}}([]",
            "{<[[]]>}<{[{[{[]{()[[[]",
            "[<(<(<(<{}))><([]([]()",
            "<{([([[(<>()){}]>(<<{{",
            "<{([{{}}[<[[[<>{}]]]>[]]"
        )

        // act
        val score = SyntaxScoring().checkProgram(program)

        // assert
        assertThat(score).isEqualTo(26397)
    }

    @Test
    fun loadProgram() {
        // arrange

        // act
        val program = SyntaxScoring().loadProgramm(".\\src\\test\\resources\\syntax_scoring_test.txt")

        // assert
        assertThat(program).hasSize(10)

    }
}
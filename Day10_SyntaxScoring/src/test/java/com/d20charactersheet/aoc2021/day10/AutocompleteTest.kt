package com.d20charactersheet.aoc2021.day10

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class AutocompleteTest {

    @Test
    fun checkSyntax_incomplete_score294() {
        // act
        val score = SyntaxScoring().checkSyntax("<{([{{}}[<[[[<>{}]]]>[]]")

        // assert
        assertThat(score).isEqualTo(294)
    }

    @Test
    fun checkSyntax_incomplete_score288957() {
        // act
        val score = SyntaxScoring().checkSyntax("[({(<(())[]>[[{[]{<()<>>")

        // assert
        assertThat(score).isEqualTo(288957)
    }

    @Test
    fun checkAutocomplete() {
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
        val middleScore = SyntaxScoring().checkAutocomplete(program)

        // assert
        assertThat(middleScore).isEqualTo(288957)
    }

}
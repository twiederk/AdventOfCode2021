package com.d20charactersheet.aoc2021.day10

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SyntaxScoringTest {

    @Test
    fun validateRoundBrackets() {
        // arrange

        // act
        val score = SyntaxScoring().checkSyntax("()")

        // assert
        assertThat(score).isEqualTo(0)
    }

}
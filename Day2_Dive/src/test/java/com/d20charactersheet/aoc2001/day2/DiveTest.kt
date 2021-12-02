package com.d20charactersheet.aoc2001.day2

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class DiveTest {

    @Test
    fun dive() {
        // arrange
//        forward 5
//        down 5
//        forward 8
//        up 3
//        down 8
//        forward 2
        val plannedCourse = listOf(
            NaviCommand(Direction.FORWARD, 5),
            NaviCommand(Direction.DOWN, 5),
            NaviCommand(Direction.FORWARD, 8),
            NaviCommand(Direction.UP, 3),
            NaviCommand(Direction.DOWN, 8),
            NaviCommand(Direction.FORWARD, 2),
        )

        // act
        val result = Dive().dive(plannedCourse)

        // assert
        assertThat(result).isEqualTo(150)
    }

}
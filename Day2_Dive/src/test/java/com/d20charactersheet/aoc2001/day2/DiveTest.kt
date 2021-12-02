package com.d20charactersheet.aoc2001.day2

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class DiveTest {


    @Test
    fun loadCourse() {

        // act
        val plannedCourse = Dive().loadCourse(".\\src\\test\\resources\\planned_course_test.txt")

        // assert
        assertThat(plannedCourse).containsExactly(
            NaviCommand(Direction.FORWARD, 5),
            NaviCommand(Direction.DOWN, 5),
            NaviCommand(Direction.FORWARD, 8),
            NaviCommand(Direction.UP, 3),
            NaviCommand(Direction.DOWN, 8),
            NaviCommand(Direction.FORWARD, 2),
        )
    }

    @Test
    fun dive() {
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
package com.d20charactersheet.aoc2021.day2

import kotlin.io.path.Path
import kotlin.io.path.readLines

class Dive {

    fun loadCourse(filename: String): List<NaviCommand> {
        val rawCourse = Path(filename).readLines()
        val plannedCourse = mutableListOf<NaviCommand>()
        for (rawNaviCommand in rawCourse) {
            val paramsNaviCommand = rawNaviCommand.split(' ')
            val direction = Direction.valueOf(paramsNaviCommand[0].uppercase())
            val value = paramsNaviCommand[1].toInt()
            plannedCourse.add(NaviCommand(direction, value))
        }
        return plannedCourse
    }

    fun dive(plannedCourse: List<NaviCommand>): Int {
        var horizontal = 0
        var depth = 0
        for (naviCommand in plannedCourse) {
            when (naviCommand.direction) {
                Direction.FORWARD -> horizontal += naviCommand.value
                Direction.DOWN -> depth += naviCommand.value
                Direction.UP -> depth -= naviCommand.value
            }
        }
        return horizontal * depth
    }

    fun diveWithAim(plannedCourse: List<NaviCommand>): Int {
        var horizontal = 0
        var depth = 0
        var aim = 0
        for (naviCommand in plannedCourse) {
            when (naviCommand.direction) {
                Direction.FORWARD -> {
                    horizontal += naviCommand.value
                    depth += (aim * naviCommand.value)
                }
                Direction.DOWN -> aim += naviCommand.value
                Direction.UP -> aim -= naviCommand.value
            }
        }
        return horizontal * depth
    }

}

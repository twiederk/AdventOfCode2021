package com.d20charactersheet.aoc2001.day2

class Dive {

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

}

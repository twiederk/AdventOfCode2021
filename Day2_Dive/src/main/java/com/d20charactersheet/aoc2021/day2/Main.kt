package com.d20charactersheet.aoc2021.day2

fun main(args: Array<String>) {
    val dive = Dive()
    val plannedCourse = dive.loadCourse(args[0])
    val result = dive.dive(plannedCourse)
    println("result = $result")
}
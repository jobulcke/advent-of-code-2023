package be.jobulcke.aoc.year2023.day08

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.drop
import kotlinx.coroutines.flow.first

fun lcm(a: Long, b: Long): Long {
    val largest = if (a > b) a else b
    val maxLcm = a * b
    var actualLcm = largest
    while (actualLcm <= maxLcm) {
        if (actualLcm % a == 0L && actualLcm % b == 0L) {
            return actualLcm
        }
        actualLcm += largest
    }
    return maxLcm
}

fun Long.lcmWith(n: Long): Long {
    return lcm(this, n)
}

fun List<Int>.lcm(): Long {
    var result: Long = this[0].toLong()
    for(i in 1 until this.size) {
        result = result.lcmWith(this[i].toLong())
    }
    return result
}

suspend inline fun Flow<Int>.lcm(): Long {
    var result: Long = this.first().toLong()
    this.drop(1).collect { result = result.lcmWith(it.toLong())}
    return result
}
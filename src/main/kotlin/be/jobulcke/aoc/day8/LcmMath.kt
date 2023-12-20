package be.jobulcke.aoc.day8

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
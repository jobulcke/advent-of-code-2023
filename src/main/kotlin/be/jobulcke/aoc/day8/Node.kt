package be.jobulcke.aoc.day8

data class Node(val value: String, val left: String, val right: String) {

    fun getNextValue(direction: Char): String {
        if(direction == 'L') {
            return left
        }
        if(direction == 'R') {
            return right
        }
        throw IllegalArgumentException("Direction must either be 'L' or 'R'")
    }

    override fun toString(): String {
        return "$value = ($left, $right)"
    }


    companion object {
        const val START_NODE_VALUE = "AAA"
        const val END_NODE_VALUE = "ZZZ"

        fun parse(line: String): Node {
            val (value, destination) = line.split(" = ")
            val (left, right) = destination.replace(Regex("[()]"), "").split(", ")
            return Node(value, left, right)
        }
    }
}
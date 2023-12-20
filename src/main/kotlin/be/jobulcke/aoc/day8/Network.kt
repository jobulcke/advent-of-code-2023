package be.jobulcke.aoc.day8

data class Network(val directions: CharArray, val nodes: List<Node>) {

    constructor(directions: String, nodes: List<Node>) : this(directions.toCharArray(), nodes)

    fun getStepsToEndNode(): Int {
        var directionsIter = directions.iterator()
        var nextNode = nodes.first { it.value == Node.START_NODE_VALUE }
        var counter = 0
        while (nextNode.value != Node.END_NODE_VALUE) {
            if (!directionsIter.hasNext()) {
                directionsIter = directions.iterator()
            }
            val nextValue = nextNode.getNextValue(directionsIter.nextChar())
            counter++
            nextNode = nodes.first { it.value == nextValue }

        }
        return counter
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Network

        if (!directions.contentEquals(other.directions)) return false
        if (nodes != other.nodes) return false

        return true
    }

    override fun hashCode(): Int {
        var result = directions.contentHashCode()
        result = 31 * result + nodes.hashCode()
        return result
    }

    companion object {
        fun parse(lines: List<String>): Network {
            val directions = lines.first().toCharArray()
            val nodes = lines.drop(2).map(Node::parse)
            return Network(directions, nodes)
        }
    }

}
package be.jobulcke.aoc.day8

data class Network(val directions: CharArray, val nodes: List<Node>) {
    val stepsToEndNode: Int
        get() = getStepsToEndNode(nodes.first { it.value == "AAA" }) { it.value == "ZZZ" }
    val allStepsToEndNodes: Long
        get() = nodes
            .filter { it.value.endsWith('A') }
            .map { startNode -> getStepsToEndNode(startNode) { it.value.endsWith('Z') } }
            .lcm()

    constructor(directions: String, nodes: List<Node>) : this(directions.toCharArray(), nodes)

    private fun getStepsToEndNode(startNode: Node, endNodeFilter: (Node) -> Boolean): Int {
        var directionsIter = directions.iterator()
        var nextNode = startNode
        var counter = 0
        while (!endNodeFilter(nextNode)) {
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
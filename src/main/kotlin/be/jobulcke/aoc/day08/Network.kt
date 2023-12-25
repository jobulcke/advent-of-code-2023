package be.jobulcke.aoc.day08

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking

data class Network(val directions: CharArray, val nodes: List<Node>) {
    val stepsToEndNode: Int
        get() = runBlocking{ getStepsToEndNode(nodes.first { it.value == "AAA" }) { it.value == "ZZZ" } }

    val allStepsToEndNodes: Long
        get() = runBlocking {
            nodes
                .filter { it.value.endsWith('A') }
                .asFlow()
                .map { startNode -> getStepsToEndNode(startNode) { it.value.endsWith('Z') } }
                .lcm()
        }

    constructor(directions: String, nodes: List<Node>) : this(directions.toCharArray(), nodes)

    private suspend fun getStepsToEndNode(startNode: Node, endNodeFilter: (Node) -> Boolean): Int {
        return runBlocking(Dispatchers.Default) {
            async {
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
                counter
            }.await()
        }
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
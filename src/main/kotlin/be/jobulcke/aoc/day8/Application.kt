import be.jobulcke.aoc.day8.Network
import kotlin.io.path.Path
import kotlin.io.path.readLines

fun main() {
    val network = Network.parse(Path("src/main/resources/day8.txt").readLines())

    println("You will reach the end node in the network in ${network.getStepsToEndNode()} steps")
}
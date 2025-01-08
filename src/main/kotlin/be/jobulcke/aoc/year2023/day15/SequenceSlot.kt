package be.jobulcke.aoc.year2023.day15

class SequenceSlot(val label: String, var focalLength: Int) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as SequenceSlot

        return label == other.label
    }

    override fun hashCode(): Int {
        return label.hashCode()
    }
}
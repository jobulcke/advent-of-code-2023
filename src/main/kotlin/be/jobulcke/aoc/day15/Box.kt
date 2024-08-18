package be.jobulcke.aoc.day15

class Box(private val id: Int) {
    private val _slots = mutableListOf<SequenceSlot>()
    val slots: List<SequenceSlot>
        get() = _slots.toList()

    val focussingPower: Int
        get() = slots
            .mapIndexed { index, sequenceSlot ->
                (id + 1) * (index + 1) * sequenceSlot.focalLength
            }
            .sum()

    fun handleSequence(sequence: Sequence) {
        sequence.run {
            if (operationSign == EqualsSignOperationSign) {
                addSequence(SequenceSlot(label, focalLength!!))
            } else removeSequence(label)
        }
    }

    private fun addSequence(sequenceSlot: SequenceSlot) {
        val slot = _slots.find { it.label == sequenceSlot.label }
        if (slot == null) {
            SequenceSlot(sequenceSlot.label, sequenceSlot.focalLength).also(_slots::add)
        } else {
            slot.focalLength = sequenceSlot.focalLength
        }
    }

    private fun removeSequence(label: String) {
        _slots.removeIf { it.label == label }
    }
}
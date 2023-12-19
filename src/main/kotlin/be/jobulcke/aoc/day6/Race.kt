package be.jobulcke.aoc.day6

data class Race(private val time: Long, private val distance: Long) {
    val numberOfWaysToWin: Int
        get() {
            var numberOfWays = 0

            (0..time).spliterator()
                .forEachRemaining {
                    if(it * (time - it) > distance) {
                        numberOfWays++
                    }
                }

            return numberOfWays
        }

}
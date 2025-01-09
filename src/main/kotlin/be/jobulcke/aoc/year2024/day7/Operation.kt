package be.jobulcke.aoc.year2024.day7

enum class Operation(val symbol: String, val execute: (Long, Int) -> Long) {
    Addition("+", Long::plus),
    Multiplication("*", Long::times),
    Concatenation("||", { a, b -> "$a$b".toLong() })
}
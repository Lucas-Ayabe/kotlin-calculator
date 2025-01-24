package com.lucas.ktcalculator.domain

class Calculator(private val operations: Map<String, (Int, Int) -> Int>) {
    fun evaluate(expression: Expression, then: (Int) -> Unit = {}) {
        val (symbol, x, y) = expression
        require(operations.containsKey(symbol)) { "Invalid operation" }
        val result = operations[symbol]?.invoke(x, y) ?: throw IllegalArgumentException("Invalid operation")
        then(result)
    }
}
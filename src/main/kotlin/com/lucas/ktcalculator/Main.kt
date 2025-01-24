package com.lucas.ktcalculator

import com.lucas.ktcalculator.domain.Calculator
import com.lucas.ktcalculator.domain.Expression
import com.lucas.ktcalculator.ui.console.Form
import com.lucas.ktcalculator.ui.console.Question

fun main() {
    try {
        val calculator = Calculator(
            mapOf(
                "+" to Int::plus,
                "-" to Int::minus,
                "*" to Int::times,
                "/" to Int::div
            )
        )

        val form = Form(
            Question("x", "Enter the first number:"),
            Question("y", "Enter the second number:"),
            Question("operation", "Choose your operation: +, -, *, /:")
        )

        form.ask().submit { answers ->
            val x = answers.field("x").asInt()
            val y = answers.field("y").asInt()
            val operation = answers.field("operation").asString()

            calculator.evaluate(Expression(operation, x, y)) { result ->
                println("Result: $result")
            }
        }
    } catch (exception: Exception) {
        println(exception.message)
    }
}
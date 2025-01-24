package com.lucas.ktcalculator.ui.console

class Question(private val name: String, private val text: String) {
    private var answer: String = ""

    fun ask(): Question {
        println(text)
        answer = readlnOrNull() ?: ""
        return this
    }

    fun submit(consumer: (Pair<String, String>) -> Unit): Question {
        consumer(name to answer)
        return this
    }
}
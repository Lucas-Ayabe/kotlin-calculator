package com.lucas.ktcalculator.ui.console

import com.lucas.ktcalculator.ui.Report

class Form(private vararg val questions: Question) {
    private var answers: Map<String, String> = emptyMap()

    fun ask(): Form {
        questions.forEach { question ->
            question.ask().submit { answers += it }
        }

        return this
    }

    fun submit(consumer: (Report) -> Unit): Form {
        consumer(Report(answers))
        return this
    }
}
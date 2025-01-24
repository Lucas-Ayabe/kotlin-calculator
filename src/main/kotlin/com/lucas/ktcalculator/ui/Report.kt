package com.lucas.ktcalculator.ui

class Report(private val answers: Map<String, String>) {
    inner class Field(private val value: String) {
        fun asString(): String {
            return value ?: ""
        }

        fun asInt(): Int {
            return value.toIntOrNull() ?: 0
        }
    }

    fun field(named: String): Field {
        return Field(answers[named] ?: "")
    }
}
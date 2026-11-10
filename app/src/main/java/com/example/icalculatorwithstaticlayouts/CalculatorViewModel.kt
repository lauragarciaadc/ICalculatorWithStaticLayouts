package com.example.icalculatorwithstaticlayouts

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CalculatorViewModel : ViewModel() {
    val displayText = MutableLiveData<String>("0")
    private var firstOperand: Double? = null
    private var pendingOperation: String? = null
    private var isNewOp = true

    fun onNumberClick(number: String) {
        if (isNewOp || displayText.value == "0" || displayText.value == "Error") {
            displayText.value = number
            isNewOp = false
        } else {
            displayText.value = displayText.value + number
        }
    }

    fun onOperationClick(op: String) {
        val currentValue = displayText.value?.toDoubleOrNull()
        if (currentValue != null) {
            firstOperand = currentValue
            pendingOperation = op
            isNewOp = true
        }
    }

    fun onEqualsClick() {
        val first = firstOperand
        val second = displayText.value?.toDoubleOrNull()

        if (first != null && second != null && pendingOperation != null) {
            val result = when (pendingOperation) {
                "+" -> first + second
                "-" -> first - second
                "*" -> first * second
                "/" -> {
                    if (second == 0.0) {
                        "Error"
                    } else {
                        first / second
                    }
                }
                else -> second
            }

            if (result is Double) {
                displayText.value = if (result % 1.0 == 0.0) {
                    result.toLong().toString()
                } else {
                    result.toString()
                }
            } else {
                displayText.value = result.toString()
            }

            firstOperand = null
            pendingOperation = null
            isNewOp = true
        }
    }
    fun onClearClick() {
        displayText.value = "0"
        firstOperand = null
        pendingOperation = null
        isNewOp = true
    }
}
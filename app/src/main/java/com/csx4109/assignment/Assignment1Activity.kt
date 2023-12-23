package com.csx4109.assignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.csx4109.assignment.databinding.ActivityAssignment1Binding

/**
 * Page Name: Basic Calculator
 *
 * -- Description --
 * Create an app can do basic calculation, consists of
 * - textView named `tvResult`
 * - button of number 0-9 named `btn0` - `btn9`
 * - button named `btnPlus`
 * - button named `btnEqual`
 * - button named `btnClear`
 *
 * Cases
 * - When open an application, the first value in `tvResult` should be 0
 * - When type any number button and `btnPlus`, value on `tvResult` should be updated
 * - When click `btnEqual`, value on `tvResult` should updated to be the result of your calculation
 * - After click `btnEqual` to calculate the result, you should be able to type more number for further calculation
 * - When click `btnClear`, value on `tvResult` should return to 0
 */
class Assignment1Activity : AppCompatActivity() {
    private val view: ActivityAssignment1Binding by lazy {ActivityAssignment1Binding.inflate(layoutInflater)}

    // Variables to store the calculation state
    private var currentInput: Int = 0
    private var result: Int = 0
    private var lastOperator: Operator? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(view.root)

        updateResultText()

        // Set click listeners for number buttons
        setNumberButtonListeners()

        // Set click listener for btnPlus
        view.btnPlus.setOnClickListener {
            handleOperator(Operator.PLUS)
        }

        // Set click listener for btnEqual
        view.btnEqual.setOnClickListener {
            calculateResult()
        }

        // Set click listener for btnClear
        view.btnClear.setOnClickListener {
            clearResult()
        }
    }

    private fun setNumberButtonListeners() {
        val numberButtons = arrayOf(view.btn0, view.btn1, view.btn2, view.btn3, view.btn4, view.btn5, view.btn6, view.btn7, view.btn8, view.btn9)

        for (i in numberButtons.indices) {
            numberButtons[i].setOnClickListener {
                handleNumberButton(i)
            }
        }
    }

    private fun handleNumberButton(number: Int) {
        if (currentInput == 0) {
            currentInput = number
        } else {
            currentInput = currentInput * 10 + number
        }
        updateResultText()
    }

    private fun handleOperator(operator: Operator) {
        if (lastOperator != null) {
            calculateResult()
        }

        result = currentInput
        currentInput = 0
        lastOperator = operator
        updateResultText()
    }

    private fun calculateResult() {
        if (lastOperator != null) {
            when (lastOperator) {
                Operator.PLUS -> result += currentInput
                // Add more cases for other operators if needed
                else -> {}
            }
            currentInput = result  // Update currentInput with the result
            lastOperator = null
            result = 0  // Reset result for future calculations
            updateResultText()
        }
    }

    private fun clearResult() {
        currentInput = 0
        result = 0
        lastOperator = null
        updateResultText()
    }

    private fun updateResultText() {
        view.tvResult.text = when {
            lastOperator == null -> currentInput.toString()
            currentInput == 0 && lastOperator != null -> "$result${getOperatorSymbol(lastOperator!!)}"
            else -> "$result${getOperatorSymbol(lastOperator!!)}$currentInput"
        }
    }

    private fun getOperatorSymbol(operator: Operator): String {
        return when (operator) {
            Operator.PLUS -> "+"
            // Add symbols for other operators if needed
        }
    }

    enum class Operator {
        PLUS,
        // Add more operators if needed
    }
}
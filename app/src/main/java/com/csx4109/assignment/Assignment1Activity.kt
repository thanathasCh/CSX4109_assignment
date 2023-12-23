package com.csx4109.assignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
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

    private lateinit var view: ActivityAssignment1Binding
    private var currentInput: String = "0"
    private var currentOperator: String? = null
    private var operand1: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        view = ActivityAssignment1Binding.inflate(layoutInflater)
        setContentView(view.root)

        // Set onClickListeners for number buttons
        val numberButtons = listOf<Button>(
            view.btn0, view.btn1, view.btn2, view.btn3, view.btn4,
            view.btn5, view.btn6, view.btn7, view.tbn8, view.btn9
        )

        for (button in numberButtons) {
            button.setOnClickListener { onNumberClick(button.text.toString()) }
        }

        // Set onClickListener for operator buttons
        val operatorButtons = listOf<Button>(
            view.btnPlus
            // Add more operator buttons as needed
        )

        for (button in operatorButtons) {
            button.setOnClickListener { onOperatorClick(button.text.toString()) }
        }

        // Set onClickListeners for Equal and Clear buttons
        view.btnEqual.setOnClickListener { onEqualClick() }
        view.btnClear.setOnClickListener { onClearClick() }
    }

    private fun onNumberClick(number: String) {
        if (currentInput == "0" || currentInput == "-0") {
            currentInput = number
        } else {
            currentInput += number
        }
        updateDisplay()
    }

    private fun onOperatorClick(operator: String) {
        if (currentOperator != null) {
            performCalculation()
        }
        currentOperator = operator
        operand1 = currentInput.toDouble()
        currentInput = "0"
    }

    private fun onEqualClick() {
        if (currentOperator != null) {
            performCalculation()
            currentOperator = null
        }
    }

    private fun onClearClick() {
        currentInput = "0"
        currentOperator = null
        operand1 = 0.0
        updateDisplay()
    }

    private fun performCalculation() {
        val operand2 = currentInput.toDouble()
        when (currentOperator) {
            "+" -> operand1 += operand2
            // Add cases for other operators if needed
        }
        currentInput = operand1.toString()
        updateDisplay()
    }

    private fun updateDisplay() {
        view.tvResult.text = currentInput
    }
}
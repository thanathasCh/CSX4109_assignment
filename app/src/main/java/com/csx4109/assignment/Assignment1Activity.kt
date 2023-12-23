package com.csx4109.assignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.csx4109.assignment.databinding.ActivityAssignment1Binding
import com.csx4109.assignment.databinding.ActivityExampleAssignmentBinding
import java.util.function.BinaryOperator

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
    private val view: ActivityAssignment1Binding by lazy { ActivityAssignment1Binding.inflate(layoutInflater) }

    private var currentInput: String = ""
    private var firstOperand: String = ""
    private var currentOperator: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(view.root)

        setButtonClickListeners()
        }

    private fun setButtonClickListeners() {
        view.btn0.setOnClickListener { onNumberButtonClick("0") }
        view.btn1.setOnClickListener { onNumberButtonClick("1") }
        view.btn2.setOnClickListener { onNumberButtonClick("2") }
        view.btn3.setOnClickListener { onNumberButtonClick("3") }
        view.btn4.setOnClickListener { onNumberButtonClick("4") }
        view.btn5.setOnClickListener { onNumberButtonClick("5") }
        view.btn6.setOnClickListener { onNumberButtonClick("6") }
        view.btn7.setOnClickListener { onNumberButtonClick("7") }
        view.btn8.setOnClickListener { onNumberButtonClick("8") }
        view.btn9.setOnClickListener { onNumberButtonClick("9") }
        view.btnPlus.setOnClickListener { onOperatorButtonClick("+") }
        view.btnClear.setOnClickListener { onClearButtonClick() }
        view.btnEqual.setOnClickListener { onEqualButtonClick() }
    }

    private fun updateDisplay() {
        view.tvResult.text = currentInput
    }

    private fun onNumberButtonClick(number: String) {
        currentInput += number
        updateDisplay()
    }

    private fun onOperatorButtonClick(operator: String) {
        if (currentInput.isNotEmpty()) {
            currentOperator = operator
            firstOperand = currentInput
            currentInput += operator
            updateDisplay()
        }
    }

    private fun onEqualButtonClick() {
        if (currentOperator != null && currentInput.isNotEmpty() && firstOperand.isNotEmpty()) {
            val secondOperand = currentInput.substringAfter(currentOperator!!)
            when (currentOperator) {
                "+" -> {
                    val result = (firstOperand.toInt() + secondOperand.toInt()).toString()
                    currentInput = result
                    firstOperand = ""
                }
                // Add similar cases for other operators if needed
            }
            currentOperator = null
            updateDisplay()
        }
    }

    private fun onClearButtonClick() {
        currentInput = "0"
        firstOperand = ""
        currentOperator = null
        updateDisplay()
    }
}
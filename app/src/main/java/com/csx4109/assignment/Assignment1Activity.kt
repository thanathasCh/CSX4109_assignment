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
    private val view: ActivityAssignment1Binding by lazy {
        ActivityAssignment1Binding.inflate(
            layoutInflater
        )
    }
    private var currentInput: String = ""
    private var currentOperator: String? = null
    private var operand1: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(view.root)

        view.btn0.setOnClickListener { newView("0") }
        view.btn1.setOnClickListener { newView("1") }
        view.btn2.setOnClickListener { newView("2") }
        view.btn3.setOnClickListener { newView("3") }
        view.btn4.setOnClickListener { newView("4") }
        view.btn5.setOnClickListener { newView("5") }
        view.btn6.setOnClickListener { newView("6") }
        view.btn7.setOnClickListener { newView("7") }
        view.btn8.setOnClickListener { newView("8") }
        view.btn9.setOnClickListener { newView("9") }
        view.btnPlus.setOnClickListener { newOperator("+") }
        view.btnClear.setOnClickListener { newClear() }
        view.btnEqual.setOnClickListener { newEqual() }
    }

    private fun updateDisplay() {
        view.tvResult.text = currentInput
    }

    private fun newView(number: String) {
        if(currentOperator == null){
            currentInput = if (currentInput == "0") number else currentInput + number
        }else{
            currentInput += number
        }
        updateDisplay()
    }

    private fun newOperator(operator: String) {
        if (currentInput.isNotEmpty()) {
            operand1 = currentInput.toInt()
            currentInput = "$operand1$operator"
            currentOperator = operator
            updateDisplay()
        }
    }

    private fun newEqual() {
        if (currentOperator != null && currentInput.isNotEmpty()) {
            val operand2 = currentInput.substringAfter('+', "0").toInt()
            when (currentOperator) {
                "+" -> operand1 += operand2
                // Add similar cases for other operators
            }
            currentInput = operand1.toString()
            currentOperator = null
            updateDisplay()
        }
    }

    private fun newClear() {
        currentInput = "0"
        currentOperator = null
        operand1 = 0
        updateDisplay()
    }
}
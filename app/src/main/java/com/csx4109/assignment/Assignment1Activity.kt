package com.csx4109.assignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

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

    private lateinit var tvResult: TextView
    private var currentInput: String = ""
    private var currentOperator: String? = null
    private var result: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_assignment1)

        tvResult = findViewById(R.id.tvResult)
        setOnClickListeners()
    }

    private fun setOnClickListeners() {
        val numberButtons = listOf<Button>(
            findViewById(R.id.btn0),
            findViewById(R.id.btn1),
            findViewById(R.id.btn2),
            findViewById(R.id.btn3),
            findViewById(R.id.btn4),
            findViewById(R.id.btn5),
            findViewById(R.id.btn6),
            findViewById(R.id.btn7),
            findViewById(R.id.btn8),
            findViewById(R.id.btn9)
        )

        for (button in numberButtons) {
            button.setOnClickListener { onNumberButtonClick(it) }
        }

        findViewById<Button>(R.id.btnPlus).setOnClickListener { onOperatorButtonClick("+") }
        findViewById<Button>(R.id.btnEqual).setOnClickListener { onEqualButtonClick() }
        findViewById<Button>(R.id.btnClear).setOnClickListener { onClearButtonClick() }
    }

    private fun onNumberButtonClick(view: View) {
        val number = (view as Button).text.toString()
        currentInput += number
        updateDisplay()
    }

    private fun onOperatorButtonClick(operator: String) {
        if (currentInput.isNotEmpty()) {
            currentOperator = operator
            result = currentInput.toInt()
            currentInput = ""
        }
    }

    private fun onEqualButtonClick() {
        if (currentInput.isNotEmpty() && currentOperator != null) {
            val secondOperand = currentInput.toInt()
            when (currentOperator) {
                "+" -> result += secondOperand
                // Add more cases for other operators if needed
            }
            currentOperator = null
            currentInput = result.toString()
            updateDisplay()
        }
    }

    private fun onClearButtonClick() {
        currentInput = ""
        currentOperator = null
        result = 0
        updateDisplay()
    }

    private fun updateDisplay() {
        tvResult.text = currentInput.takeIf { it.isNotEmpty() } ?: "0"
    }
}

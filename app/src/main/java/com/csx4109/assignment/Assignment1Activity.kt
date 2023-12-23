
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

package com.csx4109.assignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.csx4109.assignment.databinding.ActivityAssignment1Binding

class Assignment1Activity : AppCompatActivity() {
    private val view: ActivityAssignment1Binding by lazy { ActivityAssignment1Binding.inflate(layoutInflater) }

    private var currentExpression: String = ""
    private var result: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(view.root)

        // Initial display
        view.tvResult.text = "0"

        // Number button clicks
        view.apply {
            btn0.setOnClickListener { appendToExpression("0") }
            btn1.setOnClickListener { appendToExpression("1") }
            btn2.setOnClickListener { appendToExpression("2") }
            btn3.setOnClickListener { appendToExpression("3") }
            btn4.setOnClickListener { appendToExpression("4") }
            btn5.setOnClickListener { appendToExpression("5") }
            btn6.setOnClickListener { appendToExpression("6") }
            btn7.setOnClickListener { appendToExpression("7") }
            btn8.setOnClickListener { appendToExpression("8") }
            btn9.setOnClickListener { appendToExpression("9") }
        }

        // Operator button clicks
        view.btnPlus.setOnClickListener { appendToExpression("+") }

        // Equal button click
        view.btnEqual.setOnClickListener { calculate() }

        // Clear button click
        view.btnClear.setOnClickListener { clear() }
    }

    private fun appendToExpression(value: String) {
        currentExpression += value
        view.tvResult.text = currentExpression
    }

    private fun calculate() {
        // Split the expression to extract the operator and the second number
        val parts = currentExpression.split(Regex("[+]"))
        if (parts.size == 2) {
            val operator = currentExpression[parts[0].length].toString()
            val firstNumber = parts[0].toIntOrNull() ?: 0
            val secondNumber = parts[1].toIntOrNull() ?: 0

            when (operator) {
                "+" -> result = firstNumber + secondNumber
            }
            view.tvResult.text = result.toString()
            currentExpression = result.toString()
        }
    }

    private fun clear() {
        currentExpression = ""
        result = 0
        view.tvResult.text = "0"
    }
}

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
    private val view:ActivityAssignment1Binding by lazy { ActivityAssignment1Binding.inflate(layoutInflater) }
    private var currentResult: Int = 0
    private var currentInput: String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(view.root)

        updateResult()

        view.btnClear.setOnClickListener {
            view.tvResult.text = "0"
            currentResult = 0
            currentInput = ""
            updateResult()
        }


        val numberButtons = arrayOf(
            view.btn0, view.btn1, view.btn2, view.btn3, view.btn4,
            view.btn5, view.btn6, view.btn7, view.btn8, view.btn9
        )

        for (button in numberButtons) {
            button.setOnClickListener {
                onNumberButtonClick((it as Button).text.toString())
            }
        }

        view.btnPlus.setOnClickListener {
            onOperatorButtonClick("+")
        }


        view.btnEqual.setOnClickListener {
            calculateResult()
        }
    }

    private fun onNumberButtonClick(number: String) {
        currentInput += number
        updateResult()
    }
    private fun updateResult() {
        val resultText = if (currentInput.isNotEmpty()) currentInput else currentResult.toString()
        view.tvResult.text = resultText
    }
    private fun onOperatorButtonClick(operator: String) {
        if (currentInput.isNotEmpty()) {
            currentResult = currentInput.toInt()
            currentInput = currentInput + "+"
            view.tvResult.text = currentInput
        }
    }

    fun calculateSum(expression: String): Int {
        val regex = Regex("""(\d+)\s*\+\s*(\d+)""")
        val matchResult = regex.find(expression) ?: throw IllegalArgumentException("Invalid expression format (must be in the form 'number + number')")

        val (num1, num2) = matchResult.destructured

        val number1 = num1.toInt()
        val number2 = num2.toInt()

        return number1 + number2
    }

    fun calculateResult() {
        currentResult = calculateSum(currentInput)
        currentInput = currentResult.toString()
        updateResult()
    }
}
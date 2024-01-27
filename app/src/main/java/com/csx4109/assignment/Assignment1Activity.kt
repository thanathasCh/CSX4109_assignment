package com.csx4109.assignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.csx4109.assignment.databinding.ActivityAssignment1Binding
import android.widget.Button


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

    private lateinit var binding: ActivityAssignment1Binding
    private var currentExpression: String = ""
    private var lastNumeric: Boolean = false
    private var lastDot: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAssignment1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize the display
        resetDisplay()

        // Setting up click listeners for number buttons
        val numberButtons = listOf(
            binding.btn0, binding.btn1, binding.btn2, binding.btn3, binding.btn4,
            binding.btn5, binding.btn6, binding.btn7, binding.btn8, binding.btn9
        )

        numberButtons.forEach { button ->
            button.setOnClickListener { appendNumber((it as Button).text.toString()) }
        }

        // Plus button
        binding.btnPlus.setOnClickListener {
            if (lastNumeric && !currentExpression.endsWith("+")) {
                currentExpression += " + "
                binding.tvResult.text = currentExpression
                lastNumeric = false
                lastDot = false
            }
        }

        // Equal button
        binding.btnEqual.setOnClickListener {
            if (lastNumeric) {
                calculateResult()
                lastNumeric = false
            }
        }

        // Clear button
        binding.btnClear.setOnClickListener {
            resetDisplay()
        }
    }

    private fun appendNumber(number: String) {
        if (binding.tvResult.text.toString() == "0") {
            currentExpression = number
        } else {
            currentExpression += number
        }
        binding.tvResult.text = currentExpression
        lastNumeric = true
    }

    private fun calculateResult() {
        // Calculate the result of the current expression
        try {
            val result = eval(currentExpression)
            // Check if the result is a whole number and format accordingly
            binding.tvResult.text = if (result % 1.0 == 0.0) {
                result.toInt().toString()  // Convert to Int and then to String to remove the ".0"
            } else {
                result.toString()
            }
            currentExpression = binding.tvResult.text.toString()
        } catch (e: Exception) {
            binding.tvResult.text = "Error"
            currentExpression = ""
        }
    }


    private fun resetDisplay() {
        currentExpression = "0"
        binding.tvResult.text = currentExpression
        lastNumeric = false
        lastDot = false
    }

    // A simple evaluator for the expression (this is a very basic implementation and might not handle complex cases)
    private fun eval(expression: String): Double {
        // Example: split "0 + 5 + 8" into numbers and sum them up
        val numbers = expression.split(" + ")
        return numbers.sumOf { it.toDouble() }
    }
}
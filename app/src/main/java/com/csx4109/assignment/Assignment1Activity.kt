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
    private val view: ActivityAssignment1Binding by lazy { ActivityAssignment1Binding.inflate(layoutInflater) }
    private var currentResult: Int = 0
    private var currentNumber: Int = 0
    private var pendingOperation: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(view.root)

        initView()

        view.btnPlus.setOnClickListener {
            handleOperationClick("+")
        }

        view.btnEqual.setOnClickListener {
            handleEqualClick()
        }

        view.btnClear.setOnClickListener {
            handleClearClick()
        }

        // Handle number buttons
        val numberButtons = arrayOf(
            view.btn0, view.btn1, view.btn2, view.btn3, view.btn4,
            view.btn5, view.btn6, view.btn7, view.btn8, view.btn9
        )

        for (button in numberButtons) {
            button.setOnClickListener {
                handleNumberClick(button.text.toString().toInt())
            }
        }
    }

    private fun initView() {
        view.tvResult.text = "0"
    }

    private fun handleNumberClick(number: Int) {
        if (pendingOperation == null) {
            currentNumber = currentNumber * 10 + number
        } else {
            currentNumber = number
        }
        view.tvResult.text = currentNumber.toString()
    }

    private fun handleOperationClick(operation: String) {
        if (pendingOperation != null) {
            handleEqualClick()
        }
        pendingOperation = operation
        currentResult = currentNumber
        currentNumber = 0
        view.tvResult.text = "0"
    }

    private fun handleEqualClick() {
        if (pendingOperation != null) {
            when (pendingOperation) {
                "+" -> currentResult += currentNumber
                // Add more operations if needed
            }
            pendingOperation = null
            currentNumber = 0
            view.tvResult.text = currentResult.toString()
        }
    }

    private fun handleClearClick() {
        currentResult = 0
        currentNumber = 0
        pendingOperation = null
        view.tvResult.text = "0"
    }
}
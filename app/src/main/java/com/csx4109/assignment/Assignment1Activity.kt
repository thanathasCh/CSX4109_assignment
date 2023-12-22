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
    private var firstNumber: Int = 0
    private var secondNumber: Int = 0
    private var isSumPending = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(view.root)

        view.tvResult.text = "0"

        view.btn0.setOnClickListener { addNumber("0") }
        view.btn1.setOnClickListener { addNumber("1") }
        view.btn2.setOnClickListener { addNumber("2") }
        view.btn3.setOnClickListener { addNumber("3") }
        view.btn4.setOnClickListener { addNumber("4") }
        view.btn5.setOnClickListener { addNumber("5") }
        view.btn6.setOnClickListener { addNumber("6") }
        view.btn7.setOnClickListener { addNumber("7") }
        view.btn8.setOnClickListener { addNumber("8") }
        view.btn9.setOnClickListener { addNumber("9") }

        view.btnPlus.setOnClickListener { performSum() }
        view.btnEqual.setOnClickListener { calculateResult() }
        view.btnClear.setOnClickListener { clear() }
    }

    private fun addNumber(number: String) {
        val currentText = view.tvResult.text.toString()
        view.tvResult.text = if (currentText == "0" || isSumPending) number else "$currentText$number"
        isSumPending = false
    }

    private fun performSum() {
        firstNumber = view.tvResult.text.toString().toInt()
        isSumPending = true
        view.tvResult.text = firstNumber.toString() + "+"
    }

    private fun calculateResult() {
        var previousInput = view.tvResult.text.toString()
        var secondNumber = previousInput.substringBefore("+")
        view.tvResult.text = (firstNumber.toInt() + secondNumber.toInt()).toString()
        isSumPending = false
    }

    private fun clear() {
        view.tvResult.text = "0"
        firstNumber = 0
        secondNumber = 0
        isSumPending = false
    }
}



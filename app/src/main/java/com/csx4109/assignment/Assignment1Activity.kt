package com.csx4109.assignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
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
    private val view: ActivityAssignment1Binding by lazy { ActivityAssignment1Binding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(view.root)

        view.tvResult.text = "0"

        view.btn0.setOnClickListener {
            handleButtonClick("0")
        }

        view.btn1.setOnClickListener {
            handleButtonClick("1")
        }

        view.btn2.setOnClickListener {
            handleButtonClick("2")
        }

        view.btn3.setOnClickListener {
            handleButtonClick("3")
        }

        view.btn4.setOnClickListener {
            handleButtonClick("4")
        }

        view.btn5.setOnClickListener {
            handleButtonClick("5")
        }

        view.btn6.setOnClickListener {
            handleButtonClick("6")
        }

        view.btn7.setOnClickListener {
            handleButtonClick("7")
        }

        view.btn8.setOnClickListener {
            handleButtonClick("8")
        }

        view.btn9.setOnClickListener {
            handleButtonClick("9")
        }

        view.btnPlus.setOnClickListener {
            handleButtonClick("+")
        }

        view.btnEqual.setOnClickListener {
            calculateResult()
        }

        view.btnClear.setOnClickListener {
            clearResult()
        }
    }
    private fun handleButtonClick(value: String) {
        val currentText = view.tvResult.text.toString()
        val newValue = if (currentText == "0") {
            value
        } else {
            currentText + value
        }

        view.tvResult.text = newValue
    }
    private fun calculateResult() {
        val oldValue = view.tvResult.text.toString()
        val numbers = oldValue.split("+")

        if (numbers.isNotEmpty()) {
            val result = numbers.map { it.toInt() }.sum()
            view.tvResult.text = result.toString()
        }
    }
    private fun clearResult() {
        view.tvResult.text = "0"
    }
}

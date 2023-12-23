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
    private val view: ActivityAssignment1Binding by lazy { ActivityAssignment1Binding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(view.root)


        view.btn1.setOnClickListener {
            appendNumber("1")
        }

        view.btn2.setOnClickListener {
            appendNumber("2")
        }

        view.btn3.setOnClickListener {
            appendNumber("3")
        }

        view.btn4.setOnClickListener {
            appendNumber("4")
        }

        view.btn5.setOnClickListener {
            appendNumber("5")
        }

        view.btn6.setOnClickListener {
            appendNumber("6")
        }

        view.btn7.setOnClickListener {
            appendNumber("7")
        }

        view.btn8.setOnClickListener {
            appendNumber("8")
        }

        view.btn9.setOnClickListener {
            appendNumber("9")
        }

        view.btn0.setOnClickListener {
            appendNumber("0")
        }

        view.btnPlus.setOnClickListener {
            performOperation("+")
        }

        view.btnEqual.setOnClickListener {
            calculateResult()
        }

        view.btnClear.setOnClickListener {
            clearResult()
        }
    }

    private var currentOperator: String? = null
    private var firstValue: Int = 0
    private fun appendNumber(number: String) {
        val current = view.tvResult.text.toString()
        if (current == "0") {
            view.tvResult.text = number
        } else {
            view.tvResult.append(number)
        }
    }
    private fun performOperation(operator: String) {
        val currentValue = view.tvResult.text.toString().toInt()
        firstValue = currentValue
        currentOperator = operator
        view.tvResult.text = "0"
    }
    private fun calculateResult() {
        val secondValue = view.tvResult.text.toString().toInt()
        when (currentOperator) {
            "+" -> {
                val result = firstValue + secondValue
                view.tvResult.text = result.toString()
            }
        }
    }
    private fun clearResult() {
        view.tvResult.text = "0"
        currentOperator = null
        firstValue = 0
    }
}
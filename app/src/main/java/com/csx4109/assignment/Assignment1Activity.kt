package com.csx4109.assignment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
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
    private val view: ActivityAssignment1Binding by lazy { ActivityAssignment1Binding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(view.root)
        view.tvResult.text = "0"

        val numberButtons = listOf(
            view.btn0, view.btn1, view.btn2, view.btn3, view.btn4,
            view.btn5, view.btn6, view.btn7, view.btn8, view.btn9
        )
        var currentInput = ""
        var currentResult = 0

        numberButtons.forEachIndexed { index, button ->
            button.setOnClickListener {
                val number = index.toString()
                currentInput += number
                view.tvResult.text = currentInput
            }
        }

        view.btnPlus.setOnClickListener {
            currentInput += "+"
            view.tvResult.text = currentInput
        }

        view.btnEqual.setOnClickListener {
            val parts = currentInput.split("+")
            currentResult = parts.sumBy { it.toInt() }
            view.tvResult.text = currentResult.toString()
            currentInput = currentResult.toString()
        }

        view.btnClear.setOnClickListener {
            currentInput = "0"
            view.tvResult.text = currentInput
        }
    }
}
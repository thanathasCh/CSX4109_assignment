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
    private val view: ActivityAssignment1Binding by lazy { ActivityAssignment1Binding.inflate(layoutInflater) }
    private var result = 0
    private var isEqual = false
    private var plusValue = 0
    private var operationText = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(view.root)

        view.btnPlus.setOnClickListener {
            handleOperationClick("+")
        }

        view.btnEqual.setOnClickListener {
            result += plusValue
            view.tvResult.text = result.toString()
            operationText = ""
            isEqual = true
            plusValue = 0
        }

        view.btnClear.setOnClickListener {
            result = 0
            view.tvResult.text = "0"
        }

        val numberButtons = listOf(view.btn0, view.btn1, view.btn2, view.btn3, view.btn4, view.btn5, view.btn6, view.btn7, view.btn8, view.btn9)

        numberButtons.forEach { button ->
            button.setOnClickListener {
                handleNumberClick(button.text.toString().toInt())
            }
        }
    }

    private fun handleOperationClick(operator: String) {
        operationText = "$operator"
        view.tvResult.text = view.tvResult.text.toString() + operationText
    }

    private fun handleNumberClick(number: Int) {
        if (operationText.isEmpty()) {
            if (view.tvResult.text == "0" || isEqual){
                result = number
                view.tvResult.text = number.toString()
                isEqual = false
            }else{
                result = (result.toString() + number).toInt()
                view.tvResult.text = view.tvResult.text.toString() + number
            }
        } else {
            plusValue = if (plusValue == 0){
                number
            }else{
                (plusValue.toString() + number.toString()).toInt()
            }
            view.tvResult.text = view.tvResult.text.toString() + number
        }
    }
}

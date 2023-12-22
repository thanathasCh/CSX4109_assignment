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
    private var total = 0
    private var currentInput = ""
    private var showInput  = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(view.root)

        view.btnClear.setOnClickListener {
            view.tvResult.text = "0"
            currentInput = ""
            total = 0
            showInput = ""
        }
        view.btnEqual.setOnClickListener {
            val currentValue = currentInput.toInt()
            total += currentValue
            view.tvResult.text = total.toString()
            showInput = total.toString()
            currentInput = "0"
        }
        view.btn1.setOnClickListener {
            showInput += "1"
            view.tvResult.text = showInput
            currentInput += "1"
        }
        view.btn2.setOnClickListener {
            showInput += "2"
            view.tvResult.text = showInput
            currentInput += "2"
        }
        view.btn3.setOnClickListener {
            showInput += "3"
            view.tvResult.text = showInput
            currentInput += "3"
        }
        view.btn4.setOnClickListener {
            showInput += "4"
            view.tvResult.text = showInput
            currentInput += "4"
        }
        view.btn5.setOnClickListener {
            showInput += "5"
            view.tvResult.text = showInput
            currentInput += "5"
        }
        view.btn6.setOnClickListener {
            showInput += "6"
            view.tvResult.text = showInput
            currentInput += "6"
        }
        view.btn7.setOnClickListener {
            showInput += "7"
            view.tvResult.text = showInput
            currentInput += "7"
        }
        view.btn8.setOnClickListener {
            showInput += "8"
            view.tvResult.text = showInput
            currentInput += "8"
        }
        view.btn9.setOnClickListener {
            showInput += "9"
            view.tvResult.text = showInput
            currentInput += "9"
        }
        view.btn0.setOnClickListener {
            var newValue = currentInput
            if (newValue != "0") {
                newValue += "0"
                showInput += "0"
            }

            view.tvResult.text = showInput
            currentInput = newValue
        }
        view.btnPlus.setOnClickListener {
            val currentValue = currentInput.toInt()
            showInput += "+"
            view.tvResult.text = showInput
            total += currentValue
            currentInput = ""
        }
    }
}
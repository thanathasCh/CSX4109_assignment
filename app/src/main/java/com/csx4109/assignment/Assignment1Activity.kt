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
    private var currentValue = 0
    private var storedValue = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(view.root)

        setNumberButtonListeners()
        setPlusEqualButtonListeners()
        setClearButtonListeners()
    }

    private fun setClearButtonListeners() {
        view.btnClear.setOnClickListener {
            currentValue = 0
            storedValue = 0
            updateResult()
        }
    }

    private fun setPlusEqualButtonListeners() {
        view.btnPlus.setOnClickListener {
            storedValue = currentValue
            currentValue = 0
        }
        view.btnEqual.setOnClickListener {
            currentValue += storedValue
            updateResult()
        }
    }


    private fun updateResult() {
        view.tvResult.text = currentValue.toString()
    }

    private fun setNumberButtonListeners() {
        view.btn0.setOnClickListener { onNumberClicked(0) }
        view.btn1.setOnClickListener { onNumberClicked(1) }
        view.btn2.setOnClickListener { onNumberClicked(2) }
        view.btn3.setOnClickListener { onNumberClicked(3) }
        view.btn4.setOnClickListener { onNumberClicked(4) }
        view.btn5.setOnClickListener { onNumberClicked(5) }
        view.btn6.setOnClickListener { onNumberClicked(6) }
        view.btn7.setOnClickListener { onNumberClicked(7) }
        view.btn8.setOnClickListener { onNumberClicked(8) }
        view.btn9.setOnClickListener { onNumberClicked(9) }
    }

    private fun onNumberClicked(number: Int) {
        currentValue = currentValue * 10 + number
        updateResult()
    }

}
package com.csx4109.assignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.style.TtsSpan.DigitsBuilder
import android.util.Log
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
    private var currentValue = 0
    private var previousValue = 0
    private var operator: Char? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(view.root)

        view.tvResult.text = "0"

        val numberClickListener = { digit: String ->
            val newValue = updatedResult(digit)
            currentValue = currentValue * 10 + digit.toInt()
            view.tvResult.text = newValue
        }

        view.btn0.setOnClickListener { numberClickListener("0") }
        view.btn1.setOnClickListener { numberClickListener("1") }
        view.btn2.setOnClickListener { numberClickListener("2") }
        view.btn3.setOnClickListener { numberClickListener("3") }
        view.btn4.setOnClickListener { numberClickListener("4") }
        view.btn5.setOnClickListener { numberClickListener("5") }
        view.btn6.setOnClickListener { numberClickListener("6") }
        view.btn7.setOnClickListener { numberClickListener("7") }
        view.btn8.setOnClickListener { numberClickListener("8") }
        view.btn9.setOnClickListener { numberClickListener("9") }

        view.btnPlus.setOnClickListener {
            previousValue = view.tvResult.text.toString().toInt()
            view.tvResult.text = view.tvResult.text.toString()+'+'
            currentValue = 0
        }

        view.btnEqual.setOnClickListener {
            Log.i("fr", currentValue.toString())
            Log.i("fr", previousValue.toString())
            view.tvResult.text = (previousValue + currentValue.toString().toInt()).toString()
        }


        view.btnClear.setOnClickListener {
            currentValue = 0
            operator = null
            view.tvResult.text = "0"
        }
    }

    private fun updatedResult(digit: String): String {
        return if (view.tvResult.text == "0") {
            digit
        } else {
            view.tvResult.text.toString() + digit
        }
    }
}

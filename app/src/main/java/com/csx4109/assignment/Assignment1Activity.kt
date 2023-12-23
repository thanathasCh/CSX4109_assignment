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
    private val view: ActivityAssignment1Binding by lazy { ActivityAssignment1Binding.inflate(layoutInflater) }
    private lateinit var tvResult: TextView
    private var currentNumber = 0
    private var savedNumber = 0
    private var isPlusClicked = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(view.root)

        tvResult = findViewById(R.id.tvResult)

        setNumberButtonClickListeners()

        findViewById<Button>(R.id.btnPlus).setOnClickListener {
            isPlusClicked = true
            savedNumber = currentNumber
            currentNumber = 0
            updateResult()
        }

        findViewById<Button>(R.id.btnEqual).setOnClickListener {
            if (isPlusClicked) {
                currentNumber += savedNumber
                isPlusClicked = false
            }
            updateResult()
        }

        findViewById<Button>(R.id.btnClear).setOnClickListener {
            currentNumber = 0
            savedNumber = 0
            isPlusClicked = false
            updateResult()
        }
    }

    private fun setNumberButtonClickListeners() {
        val numberButtonIds = listOf(
            R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4,
            R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9
        )

        for (buttonId in numberButtonIds) {
            findViewById<Button>(buttonId).setOnClickListener {
                val number = Integer.parseInt((it as Button).text.toString())
                currentNumber = currentNumber*10 + number
                updateResult()
            }
        }
    }

    private fun updateResult() {
        tvResult.text = currentNumber.toString()
    }
}
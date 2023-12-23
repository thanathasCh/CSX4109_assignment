package com.csx4109.assignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.csx4109.assignment.databinding.ActivityAssignment1Binding

/**
 * Page Name: Basic Calculator
 *
 * -- Description --
 * Create an app can do basic calculation, consists of
 * - textView named `tvResult`
 * - button of number 0 to 9 named `btn0` to `btn9`
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
        ActivityAssignment1Binding.inflate(layoutInflater)
    }

    private var currentValue = 0
    private var previousValue = 0
    private var isPlusClicked = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(view.root)

        updateResultText()

        val numberButtonIds = listOf(
            R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4,
            R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9
        )

        for (buttonId in numberButtonIds) {
            view.root.findViewById<View>(buttonId).setOnClickListener {
                onNumberButtonClick(buttonId)
            }
        }

        view.btnPlus.setOnClickListener {
            onPlusButtonClick()
        }

        view.btnEqual.setOnClickListener {
            onEqualButtonClick()
        }

        view.btnClear.setOnClickListener {
            onClearButtonClick()
        }
    }

    private fun onNumberButtonClick(buttonId: Int) {
        val clickedNumber = view.root.findViewById<Button>(buttonId).text.toString().toInt()
        if (isPlusClicked) {
            previousValue += currentValue
            currentValue = clickedNumber
            isPlusClicked = false
        } else {
            currentValue = currentValue * 10 + clickedNumber
        }
        updateResultText()
    }

    private fun onPlusButtonClick() {
        isPlusClicked = true
        updateResultText()
    }

    private fun onEqualButtonClick() {
        if (isPlusClicked) {
            previousValue += currentValue
            isPlusClicked = false
            currentValue = previousValue // Update currentValue with the sum
        } else {
            // Handle equal button press without plus
            currentValue += previousValue
        }
        updateResultText()
        previousValue = 0 // Reset previous value after display update
    }

    private fun onClearButtonClick() {
        currentValue = 0
        previousValue = 0
        isPlusClicked = false
        updateResultText()
    }

    private fun updateResultText() {
        val resultText = if (isPlusClicked) {
            "$currentValue + "
        } else {
            currentValue.toString()
        }
        view.tvResult.text = resultText
    }

}
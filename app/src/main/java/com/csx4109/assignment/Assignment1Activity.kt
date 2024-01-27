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

/* 6411271 - Submission */
class Assignment1Activity : AppCompatActivity() {
    private val view: ActivityAssignment1Binding by lazy {
        ActivityAssignment1Binding.inflate(
            layoutInflater
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(view.root)

        val buttons = listOf(
            view.btn0,
            view.btn1,
            view.btn2,
            view.btn3,
            view.btn4,
            view.btn5,
            view.btn6,
            view.btn7,
            view.btn8,
            view.btn9
        )

        buttons.forEachIndexed { index, button ->
            button.setOnClickListener {
                val oldText =
                    if (view.tvResult.text.toString() == "0") "" else view.tvResult.text.toString()
                val text = oldText + index.toString()
                view.tvResult.text = text
            }
        }

        view.btnPlus.setOnClickListener {
            val text = view.tvResult.text.toString() + "+"
            view.tvResult.text = text
        }

        view.btnEqual.setOnClickListener {
            val text = view.tvResult.text.toString()
            val result = text
                .split("+")
                .filter { it.isNotBlank() }
                .sumOf { it.toInt() }
            view.tvResult.text = result.toString()
        }

        view.btnClear.setOnClickListener {
            view.tvResult.text = "0"
        }
    }
}
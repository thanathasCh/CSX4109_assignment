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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(view.root)

        val numbers = mutableListOf<Int>()
        var numberHolder = 0


        view.btn0.setOnClickListener {
            numberHolder = 0
        }

        view.btn1.setOnClickListener {
            numberHolder = 1
        }

        view.btn2.setOnClickListener {
            numberHolder = 2
        }

        view.btn3.setOnClickListener {
            numberHolder = 3
        }

        view.btn4.setOnClickListener {
            numberHolder = 4
        }

        view.btn5.setOnClickListener {
            numberHolder = 5
        }

        view.btn6.setOnClickListener {
            numberHolder = 6
        }

        view.btn7.setOnClickListener {
            numberHolder = 7
        }

        view.btn8.setOnClickListener {
            numberHolder = 8
        }

        view.btn9.setOnClickListener {
            numberHolder = 9
        }

        view.btnPlus.setOnClickListener {
            numbers.add(numberHolder)
            view.tvResult.text = numberHolder.toString()
        }

        view.btnClear.setOnClickListener {
            view.tvResult.text = "0"
            numberHolder = 0
            numbers.clear()
        }

        view.btnEqual.setOnClickListener {
            var result = 0

            for (number in numbers) {
                result += number
            }

            view.tvResult.text = result.toString()
        }
    }
}
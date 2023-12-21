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
    private var current_operator = ""
    private val view: ActivityAssignment1Binding by lazy {
        ActivityAssignment1Binding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(view.root)

        view.btnPlus.setOnClickListener {
            val newView = view.tvResult.text.toString() + "+"
            current_operator = "+"
            view.tvResult.text = newView

        }
        view.btn0.setOnClickListener {
            if (view.tvResult.text.toString() == "0") {
                view.tvResult.text = ""
            }
            val newView = view.tvResult.text.toString() + "0"
            view.tvResult.text = newView
        }
        view.btn1.setOnClickListener {
            if (view.tvResult.text.toString() == "0") {
                view.tvResult.text = ""
            }
            val newView = view.tvResult.text.toString() + "1"
            view.tvResult.text = newView
        }
        view.btn2.setOnClickListener {
            if (view.tvResult.text.toString() == "0") {
                view.tvResult.text = ""
            }
            val newView = view.tvResult.text.toString() + "2"
            view.tvResult.text = newView
        }
        view.btn3.setOnClickListener {
            if (view.tvResult.text.toString() == "0") {
                view.tvResult.text = ""
            }
            val newView = view.tvResult.text.toString() + "3"
            view.tvResult.text = newView
        }
        view.btn4.setOnClickListener {
            if (view.tvResult.text.toString() == "0") {
                view.tvResult.text = ""
            }
            val newView = view.tvResult.text.toString() + "4"
            view.tvResult.text = newView
        }
        view.btn5.setOnClickListener {
            if (view.tvResult.text.toString() == "0") {
                view.tvResult.text = ""
            }
            val newView = view.tvResult.text.toString() + "5"
            view.tvResult.text = newView
        }
        view.btn6.setOnClickListener {
            if (view.tvResult.text.toString() == "0") {
                view.tvResult.text = ""
            }
            val newView = view.tvResult.text.toString() + "6"
            view.tvResult.text = newView
        }
        view.btn7.setOnClickListener {
            if (view.tvResult.text.toString() == "0") {
                view.tvResult.text = ""
            }
            val newView = view.tvResult.text.toString() + "7"
            view.tvResult.text = newView
        }
        view.btn8.setOnClickListener {
            if (view.tvResult.text.toString() == "0") {
                view.tvResult.text = ""
            }
            val newView = view.tvResult.text.toString() + "8"
            view.tvResult.text = newView
        }
        view.btn9.setOnClickListener {
            if (view.tvResult.text.toString() == "0") {
                view.tvResult.text = ""
            }
            val newView = view.tvResult.text.toString() + "9"
            view.tvResult.text = newView

        }
        view.btnClear.setOnClickListener {
            view.tvResult.text = "0"
        }
        view.btnEqual.setOnClickListener {
            val equation = view.tvResult.text.toString()
            view.tvResult.text = ""
            var nums1 = ""
            var nums2 = ""
            var isOperatorFound = false
            for (i in equation) {
                when {
                    i.isDigit() -> {
                        if (!isOperatorFound) {
                            nums1 += i
                        } else {
                            nums2 += i
                        }
                    }
                    i == '+' -> {
                        isOperatorFound = true
                    }
                }
            }
            val result = nums1.toInt() + nums2.toInt()
            view.tvResult.text = result.toString()

        }

    }
}
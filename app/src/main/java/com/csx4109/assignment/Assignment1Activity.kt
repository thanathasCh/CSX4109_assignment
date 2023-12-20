package com.csx4109.assignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.csx4109.assignment.databinding.ActivityAssignment1Binding
import com.csx4109.assignment.databinding.ActivityExampleAssignmentBinding

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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(view.root)

        view.btnPlus.setOnClickListener {
            val newView = view.tvResult.text.toString()
            view.tvResult.text = newView.plus("+")
        }
        view.btn0.setOnClickListener {
            val val0 = 0
            view.tvResult.text = val0.toString()
        }
        view.btn1.setOnClickListener {
            val val1 = 1
            view.tvResult.text = val1.toString()
        }
        view.btn2.setOnClickListener {
            val val2 = 2
            view.tvResult.text = val2.toString()
        }
        view.btn3.setOnClickListener {
            val val3 = 3
            view.tvResult.text = val3.toString()
        }
        view.btn4.setOnClickListener {
            val val4 = 4
            view.tvResult.text = val4.toString()
        }
        view.btn5.setOnClickListener {
            val val5 = 5
            view.tvResult.text = val5.toString()
        }
        view.btn6.setOnClickListener {
            val val6 = 6
            view.tvResult.text = val6.toString()
        }
        view.btn7.setOnClickListener {
            val val7 = 7
            view.tvResult.text = val7.toString()
        }
        view.btn8.setOnClickListener {
            val val8 = 8
            view.tvResult.text = val8.toString()
        }
        view.btn9.setOnClickListener {
            val val9 = 9
            view.tvResult.text = val9.toString()

        }
    }
}
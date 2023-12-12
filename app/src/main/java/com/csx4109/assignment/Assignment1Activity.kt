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
    private val view: ActivityAssignment1Binding by lazy { ActivityAssignment1Binding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(view.root)

        view.btnPlus.setOnClickListener {
            val newView = view.tvResult.text.toString().toInt()
            view.tvResult.text = newView.toString()
        }
        view.btn0.setOnClickListener{
            val val1 = int 1
        }
    }
}
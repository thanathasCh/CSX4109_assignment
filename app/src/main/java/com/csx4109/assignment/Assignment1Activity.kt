package com.csx4109.assignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.csx4109.assignment.databinding.ActivityAssignment1Binding
import com.csx4109.assignment.databinding.ActivityExampleAssignmentBinding
// Assignment1

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
    private val view: ActivityAssignment1Binding by lazy{ ActivityAssignment1Binding.inflate(layoutInflater)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_assignment1)
        setContentView(view.root)

        var displayS = ""

        view.btn1.setOnClickListener{
            displayS += "1"
            view.tvResult.text = displayS
        }
        view.btn2.setOnClickListener{
            displayS += "2"
            view.tvResult.text = displayS
        }
        view.btn3.setOnClickListener{
            displayS += "3"
            view.tvResult.text = displayS
        }
        view.btn4.setOnClickListener{
            displayS += "4"
            view.tvResult.text = displayS
        }
        view.btn5.setOnClickListener{
            displayS += "5"
            view.tvResult.text = displayS
        }
        view.btn6.setOnClickListener{
            displayS += "6"
            view.tvResult.text = displayS
        }
        view.btn7.setOnClickListener{
            displayS += "7"
            view.tvResult.text = displayS
        }
        view.btn8.setOnClickListener{
            displayS += "8"
            view.tvResult.text = displayS
        }
        view.btn9.setOnClickListener{
            displayS += "9"
            view.tvResult.text = displayS
        }
        view.btn0.setOnClickListener{
            displayS += "0"
            view.tvResult.text = displayS
        }
        view.btnPlus.setOnClickListener{
            displayS += "+"
            view.tvResult.text = displayS
        }
        view.btnEqual.setOnClickListener{
            val nEqual = view.tvResult.text.toString()
            val numberArr = nEqual.split("+")
            var total = 0;
            for(i in numberArr){
                total+=i.toInt()
            }
            displayS= total.toString()
            view.tvResult.text = displayS
        }
        view.btnClear.setOnClickListener{
            val ntotal = view.tvResult.text.toString().toInt()
            val nClear = ntotal * 0
            displayS=""
            view.tvResult.text = nClear.toString()
        }

    }
}
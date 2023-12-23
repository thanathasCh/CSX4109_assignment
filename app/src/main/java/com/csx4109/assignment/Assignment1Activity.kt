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
    private var finalValue = 0
    private var addValue = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(view.root)



        view.btn0.setOnClickListener {
            ButtonClickResponse("0")
        }
        view.btn1.setOnClickListener {
            ButtonClickResponse("1")
        }
        view.btn2.setOnClickListener {
            ButtonClickResponse("2")
        }
        view.btn3.setOnClickListener {
            ButtonClickResponse("3")
        }
        view.btn4.setOnClickListener {
            ButtonClickResponse("4")
        }
        view.btn5.setOnClickListener {
            ButtonClickResponse("5")
        }
        view.btn6.setOnClickListener {
            ButtonClickResponse("6")
        }
        view.btn7.setOnClickListener {
            ButtonClickResponse("7")
        }
        view.btn8.setOnClickListener {
            ButtonClickResponse("8")
        }
        view.btn9.setOnClickListener {
            ButtonClickResponse("9")
        }
        view.btnClear.setOnClickListener {
            val newValue = "0"
            view.tvResult.text = newValue
            finalValue = 0
            addValue = ""
        }
        view.btnPlus.setOnClickListener {
            val newValue = "+"
            if (view.tvResult.text.toString().equals("0") and (view.tvResult.text.toString().length==1)){
                view.tvResult.text = newValue
            }else{
                view.tvResult.text = view.tvResult.text.toString() + "+"
            }
            finalValue += addValue.toInt()
            addValue = ""
        }
        view.btnEqual.setOnClickListener {
            finalValue += addValue.toInt()
            view.tvResult.text = finalValue.toString()
            addValue = finalValue.toString()
            finalValue = 0

        }

//        view.btnPlus.setOnClickListener {
//            val newValue = view.tvCounter.text.toString().toInt() + 1
//            view.tvCounter.text = newValue.toString()
//
//
//        } Reference
    }
    private fun ButtonClickResponse(newValue: String) {
        if (view.tvResult.text.toString() == "0" ) {
            view.tvResult.text = newValue
        } else {
            view.tvResult.text = view.tvResult.text.toString() + newValue
        }
        addValue += newValue
    }
}
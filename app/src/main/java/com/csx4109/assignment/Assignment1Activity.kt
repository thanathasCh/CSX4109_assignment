package com.csx4109.assignment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.csx4109.assignment.databinding.ActivityAssignment1Binding
import net.objecthunter.exp4j.ExpressionBuilder

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
        ActivityAssignment1Binding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(view.root)

        view.btn0.setOnClickListener {
            val newView = view.tvResult.text.toString() + "0"
            view.tvResult.text = newView.toString()
        }

        view.btn1.setOnClickListener {
            if(view.tvResult.text.toString()=="0"){
                val newView =  "1"
                view.tvResult.text = newView.toString()
            }
            else{
                val newView = view.tvResult.text.toString() + "1"
                view.tvResult.text = newView.toString()
            }
        }

        view.btn2.setOnClickListener {
            if(view.tvResult.text.toString()=="0"){
                val newView =  "2"
                view.tvResult.text = newView.toString()
            }
            else{
                val newView = view.tvResult.text.toString() + "2"
                view.tvResult.text = newView.toString()
            }
        }

        view.btn3.setOnClickListener {
            if(view.tvResult.text.toString()=="0"){
                val newView =  "3"
                view.tvResult.text = newView.toString()
            }
            else{
                val newView = view.tvResult.text.toString() + "3"
                view.tvResult.text = newView.toString()
            }
        }

        view.btn4.setOnClickListener {
            if(view.tvResult.text.toString()=="0"){
                val newView =  "4"
                view.tvResult.text = newView.toString()
            }
            else{
                val newView = view.tvResult.text.toString() + "4"
                view.tvResult.text = newView.toString()
            }
        }

        view.btn5.setOnClickListener {
            if(view.tvResult.text.toString()=="0"){
                val newView =  "5"
                view.tvResult.text = newView.toString()
            }
            else{
                val newView = view.tvResult.text.toString() + "5"
                view.tvResult.text = newView.toString()
            }

        }

        view.btn6.setOnClickListener {
            if(view.tvResult.text.toString()=="0"){
                val newView =  "6"
                view.tvResult.text = newView.toString()
            }
            else{
                val newView = view.tvResult.text.toString() + "6"
                view.tvResult.text = newView.toString()
            }
        }

        view.btn7.setOnClickListener {
            if(view.tvResult.text.toString()=="0"){
                val newView =  "7"
                view.tvResult.text = newView.toString()
            }
            else{
                val newView = view.tvResult.text.toString() + "7"
                view.tvResult.text = newView.toString()
            }
        }

        view.btn8.setOnClickListener {
            if(view.tvResult.text.toString()=="0"){
                val newView =  "8"
                view.tvResult.text = newView.toString()
            }
            else{
                val newView = view.tvResult.text.toString() + "8"
                view.tvResult.text = newView.toString()
            }
        }

        view.btn9.setOnClickListener {
            if(view.tvResult.text.toString()=="0"){
                val newView =  "9"
                view.tvResult.text = newView.toString()
            }
            else{
                val newView = view.tvResult.text.toString() + "9"
                view.tvResult.text = newView.toString()
            }
        }

        view.btnPlus.setOnClickListener {
            val newView = view.tvResult.text.toString() + "+"
            view.tvResult.text = newView.toString()
        }

        view.btnEqual.setOnClickListener {
            val newView = view.tvResult.text.toString() + "="
            view.tvResult.text = newView.toString()
        }

        view.btnEqual.setOnClickListener {
            calculateResult()
        }

        view.btnClear.setOnClickListener {
            clearCalculation()
        }
    }

    private fun updateCalculation(value: String) {
        val newExpression = view.tvResult.text.toString() + value
        view.tvResult.text = newExpression
    }

    private fun calculateResult() {
        val expression = view.tvResult.text.toString().replace("=", "")
        try {
            val result = ExpressionBuilder(expression).build().evaluate()
            view.tvResult.text = result.toInt().toString()
        } catch (e: Exception) {
            view.tvResult.text = "Error"
        }
    }

    private fun clearCalculation() {
        view.tvResult.text = "0"
    }
}


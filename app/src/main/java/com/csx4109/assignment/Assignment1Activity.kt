package com.csx4109.assignment

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
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
    private val view: ActivityAssignment1Binding by lazy { ActivityAssignment1Binding.inflate(layoutInflater)}

    private fun updateOutput(resultString: String, input: String): String {
        val stringBuilder = StringBuilder()
        Log.i("Assignment1", resultString)
        if (resultString == "0") {
            return input
        }
        val result = stringBuilder.append(resultString).append(input).toString()
        Log.i("Assignment1", result)
        return result
    }

    private fun calculate(resultString: String):String {
        val regex = Regex("[0-9]*")
        val b = regex.matches(resultString)
        if (b) {
            return resultString
        }
        val splitTokens = resultString.split("+")
        var result = 0;
        for (num in splitTokens) {
            result += num.toInt()
        }
        return result.toString()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(view.root)

        view.btn0.setOnClickListener {
            view.tvResult.text = updateOutput(view.tvResult.text.toString(), "0")

        }

        view.btn1.setOnClickListener {
            view.tvResult.text = updateOutput(view.tvResult.text.toString(), "1")
        }

        view.btn2.setOnClickListener {
            view.tvResult.text = updateOutput(view.tvResult.text.toString(), "2")

        }

        view.btn3.setOnClickListener {
            view.tvResult.text = updateOutput(view.tvResult.text.toString(), "3")
        }

        view.btn4.setOnClickListener {
            view.tvResult.text = updateOutput(view.tvResult.text.toString(), "4")
        }

        view.btn5.setOnClickListener {
            view.tvResult.text = updateOutput(view.tvResult.text.toString(), "5")

        }

        view.btn6.setOnClickListener {
            view.tvResult.text = updateOutput(view.tvResult.text.toString(), "6")
        }

        view.btn7.setOnClickListener {
            view.tvResult.text = updateOutput(view.tvResult.text.toString(), "7")
        }

        view.btn8.setOnClickListener {
            view.tvResult.text = updateOutput(view.tvResult.text.toString(), "8")

        }

        view.btn9.setOnClickListener {
            view.tvResult.text = updateOutput(view.tvResult.text.toString(), "9")
        }

        view.btnPlus.setOnClickListener {
            view.tvResult.text = updateOutput(view.tvResult.text.toString(), "+")
        }

        view.btnEqual.setOnClickListener {
            view.tvResult.text = calculate(view.tvResult.text.toString())
        }

        view.btnClear.setOnClickListener {
            view.tvResult.text = "0"
        }

    }
}
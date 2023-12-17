package com.csx4109.assignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ListAdapter
import com.csx4109.assignment.databinding.ActivityAssignment1Binding
import java.lang.StringBuilder

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
    private val viewBinding : ActivityAssignment1Binding by lazy { ActivityAssignment1Binding.inflate(layoutInflater)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)

        val buttonList : List<Button> = listOf(viewBinding.btn0, viewBinding.btn1, viewBinding
            .btn2, viewBinding.btn3, viewBinding.btn4, viewBinding.btn5, viewBinding.btn6,
            viewBinding.btn7, viewBinding.btn8, viewBinding.btn9, viewBinding.btnPlus)

        val buttonPressed = StringBuilder()
        val number1 = StringBuilder()
        val number2 = StringBuilder()

        buttonList.forEach {
            Button -> Button.setOnClickListener {
            buttonPressed.append(Button.text.toString())
                viewBinding.tvResult.text = buttonPressed.toString()
                Log.i("onCreate", buttonPressed.toString())
            }
        }

        viewBinding.btnEqual.setOnClickListener {
            val subString = buttonPressed.toString().split("+")
            number1.append(subString[0])
            number2.append(subString[1])

            Log.i("Number1", number1.toString())
            Log.i("Number2", number2.toString())

            val currentResult = number1.toString().toInt() + number2.toString().toInt()
            viewBinding.tvResult.text = currentResult.toString()
        }

        viewBinding.btnClear.setOnClickListener {
            viewBinding.tvResult.text = "0"
            buttonPressed.clear()
        }
    }
}
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
 * - button of number 0 to 9 named `btn0` to `btn9`
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

        var ExpressionDisplay = ""

        view.btn1.setOnClickListener {
            ExpressionDisplay += "1"
            view.tvResult.text = ExpressionDisplay
        }
        view.btn2.setOnClickListener {
            ExpressionDisplay += "2"
            view.tvResult.text = ExpressionDisplay
        }
        view.btn3.setOnClickListener {
            ExpressionDisplay += "3"
            view.tvResult.text = ExpressionDisplay
        }
        view.btn4.setOnClickListener {
            ExpressionDisplay += "4"
            view.tvResult.text = ExpressionDisplay
        }
        view.btn5.setOnClickListener {
            ExpressionDisplay += "5"
            view.tvResult.text = ExpressionDisplay
        }
        view.btn6.setOnClickListener {
            ExpressionDisplay += "6"
            view.tvResult.text = ExpressionDisplay
        }
        view.btn7.setOnClickListener {
            ExpressionDisplay += "7"
            view.tvResult.text = ExpressionDisplay
        }
        view.btn8.setOnClickListener {
            ExpressionDisplay += "8"
            view.tvResult.text = ExpressionDisplay
        }
        view.btn9.setOnClickListener {
            ExpressionDisplay += "9"
            view.tvResult.text = ExpressionDisplay
        }
        view.btn0.setOnClickListener {
            ExpressionDisplay += "0"
            view.tvResult.text = ExpressionDisplay
        }
        view.btnPlus.setOnClickListener {
            ExpressionDisplay += "+"
            view.tvResult.text = ExpressionDisplay
        }
        view.btnEqual.setOnClickListener {
            val nEqual = view.tvResult.text.toString()
            val numberArr = nEqual.split("+")
            var total = 0;
            for (i in numberArr) {
                total += i.toInt()
            }
            ExpressionDisplay = total.toString()
            view.tvResult.text = ExpressionDisplay
        }
        view.btnClear.setOnClickListener {
            val totalNum = view.tvResult.text.toString().toInt()
            val clearNum = totalNum * 0
            ExpressionDisplay = ""
            view.tvResult.text = clearNum.toString()
        }
    }
}
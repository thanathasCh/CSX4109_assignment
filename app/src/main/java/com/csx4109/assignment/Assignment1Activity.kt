package com.csx4109.assignment

import android.app.Activity
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
 *  * - When click `btnEqual`, value on `tvResult` should updated to be the result of your calculation
 * - After click `btnEqual` to calculate the result, you should be able to type more number for further calculation
 * - When click `btnClear`, value on `tvResult` should return to 0
 */
class Assignment1Activity : AppCompatActivity() {
    private val view : ActivityAssignment1Binding by lazy {ActivityAssignment1Binding.inflate(layoutInflater)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(view.root)

        var resultHolder = 0

        view.btnPlus.setOnClickListener {
            if (view.btn0.isActivated){
               resultHolder += 0
            }
            else if(view.btn1.isActivated){
                resultHolder +=1
            }
            else if(view.btn2.isActivated){
                resultHolder += 2
            }
            else if (view.btn3.isActivated){
                resultHolder +=3
            }
            else if (view.btn4.isActivated){
                resultHolder += 4
            }
            else if (view.btn5.isActivated){
                resultHolder += 5
            }
            else if (view.btn6.isActivated){
                resultHolder += 6
            }
            else if (view.btn7.isActivated){
                resultHolder += 7
            }
            else if (view.btn8.isActivated){
                resultHolder += 8
            }
            else if (view.btn9.isActivated) {
                resultHolder += 9
            }
        }
        view.btnClear.setOnClickListener {
            resultHolder = 0
            view.tvResult.text = resultHolder.toString()
        }

        view.btnEqual.setOnClickListener {
            view.tvResult.text = resultHolder.toString()
        }
    }
}
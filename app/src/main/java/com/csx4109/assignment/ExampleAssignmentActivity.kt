package com.csx4109.assignment

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.csx4109.assignment.databinding.ActivityExampleAssignmentBinding

/**
 * Page Name: Counting Game
 *
 * -- Description --
 * Create an app that has
 * - textView named `tvCounter`
 * - button named `btnPlus`
 * - button named `btnMinus`
 *
 * Cases
 * - When open an application, the first value in `tvCounter` should be 0
 * - When click `btnPlus`, `tvCounter` should be increased by 1
 * - When click `btnMinus`, `tvCounter` should be decreased by 1
 */

class ExampleAssignmentActivity : AppCompatActivity() {
    private val view by lazy { ActivityExampleAssignmentBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
<<<<<<< Updated upstream
        setContentView(view.root)

        view.btnPlus.setOnClickListener {
            val increase = view.tvCounter.text.toString().toInt() + 1
            view.tvCounter.text = increase.toString()
        }

        view.btnMinus.setOnClickListener {
            val decrease = view.tvCounter.text.toString().toInt() - 1
            view.tvCounter.text = decrease.toString()
        }
=======
        setContentView(R.layout.activity_example_assignment)


>>>>>>> Stashed changes
    }
}
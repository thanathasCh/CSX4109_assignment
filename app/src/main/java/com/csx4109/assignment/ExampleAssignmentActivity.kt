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

//class ExampleAssignmentActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_example_assignment)
//    }
//}

class ExampleAssignmentActivity : AppCompatActivity() {

    private lateinit var binding: ActivityExampleAssignmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.title = "Counting Game"

        super.onCreate(savedInstanceState)
        binding = ActivityExampleAssignmentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize the counter with 0
        var counterValue = 0
        binding.tvCounter.text = counterValue.toString()

        // Set up the plus button click listener
        binding.btnPlus.setOnClickListener {
            counterValue++ // Increment the counter
            binding.tvCounter.text = counterValue.toString()
        }

        // Set up the minus button click listener
        binding.btnMinus.setOnClickListener {
            counterValue-- // Decrement the counter
            binding.tvCounter.text = counterValue.toString()
        }
    }
}
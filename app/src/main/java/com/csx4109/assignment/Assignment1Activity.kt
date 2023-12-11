package com.csx4109.assignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.csx4109.assignment.databinding.ActivityAssignment1Binding

class Assignment1Activity : AppCompatActivity() {
    private lateinit var binding: ActivityAssignment1Binding
    private var currentNumber = ""
    private var previousNumber = ""
    private var operation = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAssignment1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvResult.text = "0"

        // Set up number buttons
        val numberButtons = listOf(
            binding.btn0, binding.btn1, binding.btn2, binding.btn3,
            binding.btn4, binding.btn5, binding.btn6,
            binding.btn7, binding.btn8, binding.btn9
        )

        numberButtons.forEach { button ->
            button.setOnClickListener { numberClicked(button.text.toString()) }
        }

        // Set up operation button
        binding.btnPlus.setOnClickListener {
            if (currentNumber.isNotEmpty()) {
                operationClicked("+")
                binding.tvResult.text = "$previousNumber+"
            }
        }

        // Equal button
        binding.btnEqual.setOnClickListener {
            if (previousNumber.isNotEmpty() && currentNumber.isNotEmpty()) {
                calculateResult()
                operation = "" // Reset the operation after calculation
            }
        }

        // Clear button
        binding.btnClear.setOnClickListener { clearResult() }
    }

    private fun numberClicked(num: String) {
        if (operation.isEmpty()) {
            currentNumber += num
            binding.tvResult.text = currentNumber
        } else {
            currentNumber += num
            binding.tvResult.text = "$previousNumber$operation$currentNumber"
        }
    }

    private fun operationClicked(op: String) {
        if (currentNumber.isNotEmpty()) {
            previousNumber = currentNumber
            currentNumber = ""
            operation = op
            binding.tvResult.text = "$previousNumber$op"
        }
    }

    private fun calculateResult() {
        val result = when (operation) {
            "+" -> (previousNumber.toDouble() + currentNumber.toDouble())
            // Add cases for other operations if necessary
            else -> currentNumber.toDouble()
        }
        // Format the result to remove trailing ".0" if the number is an integer
        binding.tvResult.text = if (result % 1.0 == 0.0) {
            result.toInt().toString()
        } else {
            result.toString()
        }
        currentNumber = binding.tvResult.text.toString()
        previousNumber = ""
        operation = ""
    }


    private fun clearResult() {
        currentNumber = ""
        previousNumber = ""
        operation = ""
        binding.tvResult.text = "0"
    }
}

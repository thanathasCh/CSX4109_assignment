package com.csx4109.assignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.csx4109.assignment.databinding.ActivityAssignment1Binding

class Assignment1Activity : AppCompatActivity() {
    // Lazy initialization of the binding object
    private val view: ActivityAssignment1Binding by lazy { ActivityAssignment1Binding.inflate(layoutInflater) }
    private var currentNumber = ""
    private var previousNumber = 0
    private var operation = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(view.root)
        view.tvResult.text = "0"

        setNumberButtonListeners()
        setOperationButtonListeners()
        setEqualButtonListener()
        setClearButtonListener()
    }

    private fun setNumberButtonListeners() {
        val buttonIds = listOf(
            view.btn0, view.btn1, view.btn2, view.btn3, view.btn4,
            view.btn5, view.btn6, view.btn7, view.btn8, view.btn9
        )

        buttonIds.forEach { button ->
            button.setOnClickListener { _ ->
                currentNumber += button.text.toString()
                view.tvResult.text = currentNumber
            }
        }
    }

    private fun setOperationButtonListeners() {
        view.buttonPlus.setOnClickListener {
            operation = "+"
            previousNumber = currentNumber.toInt()
            currentNumber = ""
        }
    }

    private fun setEqualButtonListener() {
        view.btnEqual.setOnClickListener {
            if (operation == "+") {
                val result = previousNumber + currentNumber.toInt()
                view.tvResult.text = result.toString()
                // Reset for the next calculation
                currentNumber = result.toString()
                previousNumber = 0
            }
        }
    }

    private fun setClearButtonListener() {
        view.btnClear.setOnClickListener {
            currentNumber = ""
            previousNumber = 0
            operation = ""
            view.tvResult.text = "0"
        }
    }
}
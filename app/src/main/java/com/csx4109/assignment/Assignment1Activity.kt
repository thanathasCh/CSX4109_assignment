package com.csx4109.assignment

import android.os.Bundle
<<<<<<< Updated upstream
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
=======
>>>>>>> Stashed changes
import com.csx4109.assignment.databinding.ActivityAssignment1Binding

class Assignment1Activity : AppCompatActivity() {
<<<<<<< Updated upstream
    private val viewBinding: ActivityAssignment1Binding by lazy {ActivityAssignment1Binding.inflate(layoutInflater)}
    private val listButtons: List<Button> by lazy {
        listOf(
            viewBinding.btn0, viewBinding.btn1, viewBinding.btn2, viewBinding.btn3, viewBinding.btn4,
            viewBinding.btn5, viewBinding.btn6, viewBinding.btn7, viewBinding.btn8, viewBinding.btn9
        ).filterNotNull()
    }
    private var currentResult: Int = 0
    private var currentNumberPressed: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)

        viewBinding.tvResult.text = "0"

        listButtons.forEach { button ->
            button.setOnClickListener {
                currentNumberPressed += button.text.toString()
            }
        }

        viewBinding.btnPlus.setOnClickListener{
            currentResult += currentNumberPressed.toInt()
        }

        viewBinding.btnEqual.setOnClickListener {
            viewBinding.tvResult.text = currentResult.toString()
        }

        viewBinding.btnClear.setOnClickListener {
            viewBinding.tvResult.text = "0"
        }
=======
    private val view : ActivityAssignment1Binding by lazy { ActivityAssignment1Binding.inflate(layoutInflater)}
    private val listOfButton : List<Button>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(view.root)

>>>>>>> Stashed changes
    }
}

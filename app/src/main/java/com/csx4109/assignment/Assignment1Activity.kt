package com.csx4109.assignment

import android.os.Bundle
<<<<<<< Updated upstream
<<<<<<< Updated upstream
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
=======
>>>>>>> Stashed changes
import com.csx4109.assignment.databinding.ActivityAssignment1Binding
=======
import android.util.Log
import android.widget.Button
import com.csx4109.assignment.databinding.ActivityAssignment1Binding
import java.lang.StringBuilder
>>>>>>> Stashed changes

class Assignment1Activity : AppCompatActivity() {
<<<<<<< Updated upstream
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
=======
    private val viewBinding : ActivityAssignment1Binding by lazy {ActivityAssignment1Binding.inflate(layoutInflater)}


>>>>>>> Stashed changes

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)

<<<<<<< Updated upstream
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
=======
        val buttonPressed = StringBuilder()
        val buttons : List<Button> = listOf(viewBinding.btn0, viewBinding.btn1, viewBinding.btn2,
            viewBinding.btn3, viewBinding.btn4, viewBinding.btn5, viewBinding.btn6, viewBinding
                .btn7, viewBinding.btn8, viewBinding.btn9, viewBinding.btnPlus)
        var currentResult : Int = 0


        buttons.forEach { Button ->
            Button.setOnClickListener {
                buttonPressed.append(Button.text.toString())
                viewBinding.tvResult.text = buttonPressed
            }
        }

        viewBinding.btnEqual.setOnClickListener {
            val subString = buttonPressed.toString().split("+")
            for(element in subString.indices){
                currentResult += element.toString().toInt()
            }
>>>>>>> Stashed changes
            viewBinding.tvResult.text = currentResult.toString()
        }

        viewBinding.btnClear.setOnClickListener {
            viewBinding.tvResult.text = "0"
<<<<<<< Updated upstream
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
=======
            currentResult = 0
        }
    }
}


>>>>>>> Stashed changes

package com.phutthiphat.assignment_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addingtwonumbers()
    }

    fun addingtwonumbers()
    {
        var num1 = findViewById<EditText>(R.id.number1)
        var num2 = findViewById<EditText>(R.id.number2)
        var button1 = findViewById<Button>(R.id.addit)
        var clearbutton = findViewById<Button>(R.id.clearbutton)
        var multiplybutton = findViewById<Button>(R.id.multiply)
        var minusbutton = findViewById<Button>(R.id.minus)
        var divide1button = findViewById<Button>(R.id.divide)

        button1.setOnClickListener {
            var addnum1 = num1.text.toString().toInt()
            var addnum2 = num2.text.toString().toInt()
            var result = addnum1 + addnum2
            Toast.makeText(this,"$result",Toast.LENGTH_SHORT).show()
        }
        multiplybutton.setOnClickListener {
            var addnum1 = num1.text.toString().toInt()
            var addnum2 = num2.text.toString().toInt()
            var resultmultiply = addnum1 * addnum2
            Toast.makeText(this,"$resultmultiply",Toast.LENGTH_SHORT).show()
        }
        minusbutton.setOnClickListener {
            var addnum1 = num1.text.toString().toInt()
            var addnum2 = num2.text.toString().toInt()
            var resultminus = addnum1 - addnum2
            Toast.makeText(this,"$resultminus",Toast.LENGTH_SHORT).show()
        }
        divide1button.setOnClickListener {
            var addnum1 = num1.text.toString().toInt()
            var addnum2 = num2.text.toString().toInt()
            var resultdivide = addnum1 / addnum2
            Toast.makeText(this,"$resultdivide",Toast.LENGTH_SHORT).show()
        }
        clearbutton.setOnClickListener {
            num1.setText("");
            num2.setText("");
            Toast.makeText(this,"Cleared",Toast.LENGTH_SHORT).show()
        }
    }
}
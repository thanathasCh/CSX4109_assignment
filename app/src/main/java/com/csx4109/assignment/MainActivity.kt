package com.csx4109.assignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.csx4109.assignment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val view: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(view.root)

        view.btnAssignment0.setOnClickListener {
            startActivity(Intent(this, ExampleAssignmentActivity::class.java))
        }

        view.btnAssignment1.setOnClickListener {
            startActivity(Intent(this, Assignment1Activity::class.java))
        }

        view.btnAssignment2.setOnClickListener {
            startActivity(Intent(this, Assignment2Activity::class.java))
        }

        view.btnAssignment3.setOnClickListener {
            startActivity(Intent(this, Assignment3Activity::class.java))
        }
    }
}
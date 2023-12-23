package com.phutthiphat.assignment0

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.phutthiphat.assignment0.databinding.MainLayoutBinding


class MainLayout : AppCompatActivity() {
    private val view: MainLayoutBinding by lazy { MainLayoutBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(view.root)

        view.btnPlus.setOnClickListener {
            val newValue = view.tvCounter.text.toString().toInt() + 1
            view.tvCounter.text = newValue.toString()
        }

        view.btnMinus.setOnClickListener {
            val newValue = view.tvCounter.text.toString().toInt() - 1
            view.tvCounter.text = newValue.toString()
        }
        view.btnReset.setOnClickListener {
            view.tvCounter.text = "0"
        }
    }
}
package com.csx4109.assignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.csx4109.assignment.databinding.FragmentABinding

class RecyclerViewActivity : AppCompatActivity() {
    private val view: FragmentABinding by lazy {FragmentABinding.inflate(layoutInflater)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(view.root)
        view.rvList.adapter = RecyclerViewAdapter(this, LocalVariables.games)
        view.rvList.layoutManager = LinearLayoutManager(this)
    }
}
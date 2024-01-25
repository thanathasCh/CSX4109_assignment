package com.csx4109.assignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.csx4109.assignment.databinding.FragmentBBinding

class RecyclerViewGrid : AppCompatActivity() {
    private val view: FragmentBBinding by lazy {FragmentBBinding.inflate(layoutInflater)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(view.root)
        view.rvGrid.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true)
        view.rvGrid.layoutManager = GridLayoutManager(this, 2)
    }
}
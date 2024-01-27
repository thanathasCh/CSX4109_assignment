package com.csx4109.assignment.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.csx4109.assignment.LocalVariables
import com.csx4109.assignment.adapters.GridAdapter
import com.csx4109.assignment.databinding.ActivityGridBinding

class GridFragment : Fragment() {
    private lateinit var view: ActivityGridBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        view = ActivityGridBinding.inflate(inflater, container, false)
        val context = requireContext()
        view.rvGrid.adapter = GridAdapter(context, LocalVariables.games)
        view.rvGrid.layoutManager = GridLayoutManager(context, 2)
        return view.root
    }
}

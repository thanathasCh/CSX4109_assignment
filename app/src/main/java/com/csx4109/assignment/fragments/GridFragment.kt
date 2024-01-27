package com.csx4109.assignment.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.csx4109.assignment.LocalVariables
import com.csx4109.assignment.adapters.GridViewAdapter
import com.csx4109.assignment.databinding.ActivityGridFragmentBinding

class GridFragment: Fragment() {
    private lateinit var view: ActivityGridFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        view = ActivityGridFragmentBinding.inflate(inflater, container, false)
        val context = requireContext()
        view.rvGrid.adapter = GridViewAdapter(context, LocalVariables.games)
        view.rvGrid.layoutManager = GridLayoutManager(context,2)
        return view.root
    }
}
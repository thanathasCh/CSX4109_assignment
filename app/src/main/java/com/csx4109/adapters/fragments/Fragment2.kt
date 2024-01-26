package com.csx4109.adapters.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.csx4109.adapters.GridViewAdapter
import com.csx4109.assignment.LocalVariables
import com.csx4109.assignment.databinding.Fragment2Binding

class Fragment2 : Fragment() {
    private lateinit var viewBinding: Fragment2Binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = Fragment2Binding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerViewAdapter = GridViewAdapter(requireContext(), LocalVariables.games)
        viewBinding.rvGrid.layoutManager = GridLayoutManager(requireContext(), 2)
        viewBinding.rvGrid.adapter = recyclerViewAdapter
    }
}
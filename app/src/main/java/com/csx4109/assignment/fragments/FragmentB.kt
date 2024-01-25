package com.csx4109.assignment.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.csx4109.assignment.GridRecyclerViewAdapter
import com.csx4109.assignment.LocalVariables
import com.csx4109.assignment.RecyclerViewAdapter
import com.csx4109.assignment.databinding.FragmentBBinding

class FragmentB : Fragment() {
    private lateinit var viewBinding: FragmentBBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentBBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerViewAdapter = GridRecyclerViewAdapter(requireContext(), LocalVariables.games)
        viewBinding.rvGrid.layoutManager = GridLayoutManager(requireContext(), 2)
        viewBinding.rvGrid.adapter = recyclerViewAdapter
    }
}

package com.csx4109.assignment.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.csx4109.assignment.LocalVariables
import com.csx4109.assignment.adapters.GridAdapter
import com.csx4109.assignment.databinding.GridFragmentBinding

class GridFragment : Fragment() {
    private lateinit var binding: GridFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = GridFragmentBinding.inflate(inflater, container, false)
        setupRecyclerView()
        return binding.root
    }

    private fun setupRecyclerView() {
        val games = LocalVariables.games
        val gridAdapter = GridAdapter(requireContext(), games)
        binding.rvGrid.adapter = gridAdapter
        binding.rvGrid.layoutManager = GridLayoutManager(requireContext(), 2)
    }
}

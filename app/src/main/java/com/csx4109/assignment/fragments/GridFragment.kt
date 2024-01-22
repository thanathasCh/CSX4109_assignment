package com.csx4109.assignment.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.csx4109.assignment.LocalVariables
import com.csx4109.assignment.adapters.GridAdapter
import com.csx4109.assignment.adapters.RecyclerViewAdapter
import com.csx4109.assignment.databinding.GridFragmentBinding
import com.csx4109.assignment.databinding.ListFragmentBinding

class GridFragment : Fragment() {

    private lateinit var binding: GridFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = GridFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize RecyclerView and set its layout manager
        val recyclerView: RecyclerView = binding.rvGrid
        recyclerView.layoutManager = GridLayoutManager(context, 2) // Adjust the span count as needed

        // Initialize GridAdapter with the list of games and set it to the RecyclerView
        val adapter = GridAdapter(requireContext(), LocalVariables.games)
        recyclerView.adapter = adapter
    }

}
package com.csx4109.assignment.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.csx4109.assignment.LocalVariables
import com.csx4109.assignment.adapters.ListAdapter
import com.csx4109.assignment.databinding.ListFragmentBinding

class ListFragment : Fragment() {
    private lateinit var binding: ListFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ListFragmentBinding.inflate(inflater, container, false)
        setupRecyclerView()
        return binding.root
    }

    private fun setupRecyclerView() {
        val games = LocalVariables.games
        val listAdapter = ListAdapter(requireContext(), games)
        binding.rvList.adapter = listAdapter
        binding.rvList.layoutManager = LinearLayoutManager(requireContext())
    }
}

package com.csx4109.assignment.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.csx4109.assignment.adapters.RecyclerViewAdapter
import com.csx4109.assignment.LocalVariables
import com.csx4109.assignment.databinding.ListFragmentBinding

class ListFragment : Fragment() {

    private lateinit var binding: ListFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ListFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize RecyclerView and set its layout manager
        val recyclerView: RecyclerView = binding.rvList
        recyclerView.layoutManager = LinearLayoutManager(context)

        // Initialize RecyclerViewAdapter with the list of games and set it to the RecyclerView
        val adapter = RecyclerViewAdapter(requireContext(), LocalVariables.games)
        recyclerView.adapter = adapter
    }
}

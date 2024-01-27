package com.csx4109.assignment.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.csx4109.assignment.LocalVariables
import com.csx4109.assignment.adapters.GameGridAdapter
import com.csx4109.assignment.databinding.FragmentGridBinding

class GridFragment : Fragment() {
    private var _binding: FragmentGridBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGridBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = GameGridAdapter(requireContext(), LocalVariables.games)
        binding.rvGrid.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.rvGrid.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
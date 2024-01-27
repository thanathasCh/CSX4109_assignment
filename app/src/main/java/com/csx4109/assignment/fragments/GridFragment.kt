//package com.csx4109.assignment.fragments
//
//import android.os.Bundle
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.fragment.app.Fragment
//import androidx.recyclerview.widget.GridLayoutManager
//import com.csx4109.assignment.LocalVariables
//import com.csx4109.assignment.adapter.GridAdapter
//import com.csx4109.assignment.databinding.FragmentGridBinding
//
//class GridFragment : Fragment() {
//    private lateinit var view: FragmentGridBinding
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View {
//        view = FragmentGridBinding.inflate(inflater, container, false)
//
//        view.rvGrid.adapter = GridAdapter(requireContext(), LocalVariables.games)
//        view.rvGrid.layoutManager = GridLayoutManager(context, 2)
//
//        return view.root
//    }
//}

package com.csx4109.assignment.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.csx4109.assignment.LocalVariables
import com.csx4109.assignment.adapter.GridAdapter
import com.csx4109.assignment.databinding.FragmentGridBinding

class GridFragment : Fragment() {
    private var _binding: FragmentGridBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGridBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        with(binding.rvGrid) {
            adapter = GridAdapter(requireContext(), LocalVariables.games)
            layoutManager = GridLayoutManager(context, 2)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null // Avoid leaking views
    }
}

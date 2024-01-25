package com.csx4109.assignment.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.csx4109.assignment.LocalVariables
import com.csx4109.assignment.RecyclerViewAdapter
import com.csx4109.assignment.databinding.FragmentABinding

class FragmentA : Fragment() {
    private lateinit var viewBinding: FragmentABinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentABinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerViewAdapter = RecyclerViewAdapter(requireContext(), LocalVariables.games)
        viewBinding.rvList.layoutManager = LinearLayoutManager(requireContext())
        viewBinding.rvList.adapter = recyclerViewAdapter
    }
}

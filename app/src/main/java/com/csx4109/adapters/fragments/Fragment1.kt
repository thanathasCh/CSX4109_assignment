package com.csx4109.adapters.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.csx4109.assignment.LocalVariables
import com.csx4109.assignment.RecyclerViewAdapter
import com.csx4109.assignment.databinding.Fragment1Binding

class Fragment1 : Fragment(){
    private lateinit var viewBinding: Fragment1Binding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = Fragment1Binding.inflate(inflater, container, false)

        return viewBinding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerViewAdapter = RecyclerViewAdapter(requireContext(), LocalVariables.games)
        viewBinding.rvList.layoutManager = LinearLayoutManager(requireContext())
        viewBinding.rvList.adapter = recyclerViewAdapter
    }
}
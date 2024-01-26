package com.csx4109.assignment.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.csx4109.assignment.Adapter.GridAdapter
import com.csx4109.assignment.LocalVariables
import com.csx4109.assignment.databinding.ActivityFragmentGridBinding

class FragmentGrid: Fragment() {
    private lateinit var view: ActivityFragmentGridBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        view = ActivityFragmentGridBinding.inflate(inflater, container,false)
        view.rvGrid.adapter = GridAdapter(requireContext(), LocalVariables.games)
        view.rvGrid.layoutManager = GridLayoutManager(requireContext(), 2)
        return view.root
    }

}
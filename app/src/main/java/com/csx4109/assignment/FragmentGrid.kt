package com.csx4109.assignment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.csx4109.assignment.adapters.grid_adapter
import com.csx4109.assignment.databinding.FragmentGridBinding

class FragmentGrid : Fragment(){

    private lateinit var view: FragmentGridBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        view = FragmentGridBinding.inflate(inflater, container,false)
        view.rvGrid.adapter = grid_adapter(requireContext(), LocalVariables.games)
        view.rvGrid.layoutManager = GridLayoutManager(requireContext(), 2)
        return view.root
    }
}


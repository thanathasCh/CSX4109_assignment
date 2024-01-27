package com.csx4109.assignment.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.csx4109.assignment.LocalVariables
import com.csx4109.assignment.adapter.GGA
import com.csx4109.assignment.databinding.FragmentGridBinding

class GF : Fragment() {
    private lateinit var view: FragmentGridBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        view = FragmentGridBinding.inflate(inflater, container, false)

        view.rvGrid.adapter = GGA(requireContext(), LocalVariables.games)
        view.rvGrid.layoutManager = GridLayoutManager(context, 2)

        return view.root
    }
}
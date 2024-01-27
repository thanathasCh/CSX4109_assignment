package com.csx4109.assignment.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.csx4109.assignment.LocalVariables
import com.csx4109.assignment.adapter.GLA
import com.csx4109.assignment.databinding.FragmentListBinding

class LF : Fragment() {
    private lateinit var view: FragmentListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        view = FragmentListBinding.inflate(inflater, container, false)

        view.rvList.adapter = GLA(LocalVariables.games)
        view.rvList.layoutManager = LinearLayoutManager(context)

        return view.root
    }
}
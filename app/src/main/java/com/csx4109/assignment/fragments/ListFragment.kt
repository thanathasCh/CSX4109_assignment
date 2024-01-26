package com.csx4109.assignment.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.csx4109.assignment.LocalVariables
import com.csx4109.assignment.adapters.ListViewAdapter
import com.csx4109.assignment.databinding.ActivityListFragmentBinding

class ListFragment: Fragment() {
    private lateinit var view: ActivityListFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        view = ActivityListFragmentBinding.inflate(inflater, container, false)

        view.rvList.adapter = ListViewAdapter(LocalVariables.games)
        view.rvList.layoutManager = LinearLayoutManager(context)
        return view.root
    }
}


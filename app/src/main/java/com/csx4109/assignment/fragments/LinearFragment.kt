package com.csx4109.assignment.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.csx4109.assignment.LocalVariables
import com.csx4109.assignment.adapters.GameGridAdapter
import com.csx4109.assignment.adapters.GameListAdapter

import com.csx4109.assignment.databinding.FragmentLinearBinding

class LinearFragment: Fragment() {
    private lateinit var view: FragmentLinearBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        view = FragmentLinearBinding.inflate(inflater, container, false)

        val games = LocalVariables.games

        view.LinearLayout.adapter = GameListAdapter(games)
        view.LinearLayout.layoutManager = LinearLayoutManager(context)

        return view.root
    }
}
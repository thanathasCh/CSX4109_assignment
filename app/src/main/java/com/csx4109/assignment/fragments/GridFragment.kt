package com.csx4109.assignment.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.csx4109.assignment.LocalVariables
import com.csx4109.assignment.adapters.GameGridAdapter
import com.csx4109.assignment.models.Game
import com.csx4109.assignment.R

class GridFragment :Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: GameGridAdapter
    private var gamesList: List<Game> = LocalVariables.games

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_grid, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.rvGrid)
        recyclerView.layoutManager = GridLayoutManager(context, 2)
        adapter = GameGridAdapter(requireContext(), gamesList)
        recyclerView.adapter = adapter
    }

}
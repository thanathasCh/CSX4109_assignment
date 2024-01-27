package com.csx4109.assignment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.csx4109.assignment.adapter.GameListAdapter
import com.csx4109.assignment.databinding.ListFragmentBinding

class ListFragment : Fragment() {
    private lateinit var view: ListFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        view = ListFragmentBinding.inflate(inflater, container, false)
        view.rvList.adapter = GameListAdapter(requireContext() , LocalVariables.games)
        view.rvList.layoutManager = LinearLayoutManager(requireContext())
        return view.root
    }
}
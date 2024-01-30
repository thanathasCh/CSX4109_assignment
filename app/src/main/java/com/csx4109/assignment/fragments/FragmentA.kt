package com.csx4109.assignment.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.csx4109.assignment.LocalVariables
import com.csx4109.assignment.adapter.ListViewAdapter
import com.csx4109.assignment.databinding.FragmentABinding


class FragmentA: Fragment()  {
    private  lateinit var viewBinding: FragmentABinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding.rvList.adapter = ListViewAdapter(LocalVariables.games)
        return viewBinding.root
    }
}
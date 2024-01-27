package com.csx4109.assignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.csx4109.assignment.databinding.ActivityAssignment2Binding
import com.csx4109.assignment.fragments.GridFragment
import com.csx4109.assignment.fragments.ListFragment

class Assignment2Activity : AppCompatActivity() {
    private val view: ActivityAssignment2Binding by lazy { ActivityAssignment2Binding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(view.root)
        if (savedInstanceState == null) {
            changeFragment(ListFragment())
        }
        view.bnvListType.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.item_list -> changeFragment(ListFragment())
                R.id.item_grid -> changeFragment(GridFragment())
                else -> false
            }
        }
    }

    private fun changeFragment(fragment: Fragment): Boolean {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fcvGameList, fragment)
            .addToBackStack(fragment::class.java.name)
            .commit()

        return true
    }
}
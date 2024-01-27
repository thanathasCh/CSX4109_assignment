package com.csx4109.assignment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.csx4109.assignment.databinding.ActivityAssignment2Binding
import com.csx4109.assignment.fragment.GF
import com.csx4109.assignment.fragment.LF


/**
 * Page Name: Game List
 *
 * -- Description --
 * Create an app that can show a list of games from `LocalVariable.games`
 * There should be 2 fragments for each navigation buttom
 * - RecyclerView - LinearLayout
 * - RecyclerView - GridLayout
 *
 * NavigationButtom menu should have 2 items
 * - menuItem with id `item_list` which should show the first fragment
 * - menuItem with id `item_grid` which should show the second fragment
 *
 * For the first fragment, you should use LinearLayout to show the list of games
 * - The recyclerView should have id of `rvList`
 * Each item should show the following information with the following id
 * - imageView named `ivGame` that load image from internet using coil library
 * - textView named `tvGameName` that show the name of the game
 * - textView named `tvGenre` that show the genre of the game
 * - textView named `tvGameScore` that show the score rating of the game
 * - textView named `tvGameDescription` that show the description of the game
 *
 * For the second fragment, you should use GridLayout to show the list of games with 2 item per row
 * - The recyclerView should have id of `rvGrid`
 * Each item should show the following information with the following id
 * - imageView named `ivGame` that load image from internet using coil library
 * - textView named `tvGameScore` that show the score rating of the game
 *
 * Cases
 * - When open an application, the first fragment should be shown as LinearLayout
 * - When click the second navigation button, the second fragment should be shown as GridLayout
 * - Each item in both view should be displayed correctly in order
 *
 * ***You can check video example in MS team***
 */
class Assignment2Activity : AppCompatActivity() {
    private val view: ActivityAssignment2Binding by lazy { ActivityAssignment2Binding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(view.root)

        view.navigation.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.item_list -> changeFragment(LF())
                R.id.item_grid -> changeFragment(GF())
                else -> false
            }
        }
    }
    private fun changeFragment(fragment: Fragment): Boolean {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fmGameList, fragment)
            .addToBackStack(fragment::class.java.name)
            .commit()

        return true
    }

}
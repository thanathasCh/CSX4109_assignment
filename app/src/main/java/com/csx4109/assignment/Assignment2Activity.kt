package com.csx4109.assignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.csx4109.assignment.fragments.ListViewFragment


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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_assignment2)
        replaceFragment(ListViewFragment())

        Log.ERROR
    }

    private fun replaceFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransction = fragmentManager.beginTransaction()
        fragmentTransction.replace(R.id.itemGameBoard, fragment)
        fragmentTransction.commit()
    }
}
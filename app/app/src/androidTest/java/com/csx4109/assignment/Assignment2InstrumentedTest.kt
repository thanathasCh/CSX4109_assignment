package com.csx4109.assignment

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.hasDescendant
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.filters.LargeTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class Assignment2InstrumentedTest {
    private lateinit var scenario: ActivityScenario<Assignment2Activity>

    @Before
    fun setup() {
        scenario = ActivityScenario.launch(Assignment2Activity::class.java)
    }

    @Test
    fun defaultViewShouldBeListFragment() {
        Thread.sleep(1000)
        onView(withId(R.id.rvList))
            .check(matches(isDisplayed()))
    }

    @Test
    fun changeFragmentWhenClickingBottomNavigation() {
        onView(withId(R.id.item_grid))
            .perform(click())
        Thread.sleep(1000)
        onView(withId(R.id.rvGrid))
            .check(matches(isDisplayed()))

        onView(withId(R.id.item_list))
            .perform(click())
        Thread.sleep(1000)
        onView(withId(R.id.rvList))
            .check(matches(isDisplayed()))
    }

    @Test
    fun listFragmentDisplayAllGamesCorrectly() {
        Thread.sleep(1000)
        LocalVariables.games.forEachIndexed { index, game ->
            onView(withId(R.id.rvList))
                .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(index))
                .check(matches(hasDescendant(withText(game.name))))
        }
    }

    @Test
    fun gridFragmentDisplayAllGamesCorrectly() {
        onView(withId(R.id.item_grid))
            .perform(click())
        Thread.sleep(1000)

        LocalVariables.games.forEachIndexed { index, game ->
            onView(withId(R.id.rvGrid))
                .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(index))
                .check(matches(hasDescendant(withText(game.rating.toString()))))
        }
    }
}
package com.csx4109.assignment

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class ExampleAssignmentInstrumentedTest {
    private lateinit var scenario: ActivityScenario<ExampleAssignmentActivity>

    @Before
    fun setup() {
        scenario = ActivityScenario.launch(ExampleAssignmentActivity::class.java)
    }

    @Test
    fun defaultValueShouldBe0() {
        onView(withId(R.id.tvCounter))
            .check(matches(withText("0")))
    }

    @Test
    fun pressPlusAndUpdateValueCorrectly() {
        for (i in 1..5) {
            onView(withId(R.id.btnPlus))
                .perform(click())

            onView(withId(R.id.tvCounter))
                .check(matches(withText(i.toString())))
        }
    }

    @Test
    fun pressMinusAndUpdateValueCorrectly() {
        for (i in -1 downTo -5) {
            onView(withId(R.id.btnMinus))
                .perform(click())

            onView(withId(R.id.tvCounter))
                .check(matches(withText(i.toString())))
        }
    }
}
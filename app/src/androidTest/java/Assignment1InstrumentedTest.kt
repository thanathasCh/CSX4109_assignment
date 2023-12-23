//package com.csx4109.assignment
//
//import androidx.test.core.app.ActivityScenario
//import androidx.test.espresso.Espresso.onView
//import androidx.test.espresso.action.ViewActions.click
//import androidx.test.espresso.assertion.ViewAssertions.matches
//import androidx.test.espresso.matcher.ViewMatchers.withId
//import androidx.test.espresso.matcher.ViewMatchers.withText
//import androidx.test.ext.junit.runners.AndroidJUnit4
//import androidx.test.filters.LargeTest
//import org.junit.Before
//import org.junit.Test
//import org.junit.runner.RunWith
//
//@LargeTest
//@RunWith(AndroidJUnit4::class)
//class Assignment1InstrumentedTest {
//    private lateinit var scenario: ActivityScenario<Assignment1Activity>
//
//    @Before
//    fun setup() {
//        scenario = ActivityScenario.launch(Assignment1Activity::class.java)
//    }
//
//    @Test
//    fun defaultValueShouldBe0() {
//        checkResult("0")
//    }
//
//    @Test
//    fun makeCalculationCorrectly() {
//        // 123 + 321
//        onView(withId(R.id.btn1))
//            .perform(click())
//        checkResult("1")
//
//        onView(withId(R.id.btn2))
//            .perform(click())
//        checkResult("12")
//
//        onView(withId(R.id.btn3))
//            .perform(click())
//        checkResult("123")
//
//        onView(withId(R.id.btnPlus))
//            .perform(click())
//        checkResult("123+")
//
//        onView(withId(R.id.btn3))
//            .perform(click())
//        checkResult("123+3")
//
//        onView(withId(R.id.btn2))
//            .perform(click())
//        checkResult("123+32")
//
//        onView(withId(R.id.btn1))
//            .perform(click())
//        checkResult("123+321")
//
//        onView(withId(R.id.btnEqual))
//            .perform(click())
//        checkResult("444")
//    }
//
//    @Test
//    fun canContinueMakeCalculation() {
//        // 1 + 2, then + 3
//        onView(withId(R.id.btn1))
//            .perform(click())
//        checkResult("1")
//
//        onView(withId(R.id.btnPlus))
//            .perform(click())
//        checkResult("1+")
//
//        onView(withId(R.id.btn2))
//            .perform(click())
//        checkResult("1+2")
//
//        onView(withId(R.id.btnEqual))
//            .perform(click())
//        checkResult("3")
//
//        onView(withId(R.id.btnPlus))
//            .perform(click())
//        checkResult("3+")
//
//        onView(withId(R.id.btn3))
//            .perform(click())
//        checkResult("3+3")
//
//        onView(withId(R.id.btnEqual))
//            .perform(click())
//        checkResult("6")
//    }
//
//    @Test
//    fun canClearValue() {
//        onView(withId(R.id.btn1))
//            .perform(click())
//        checkResult("1")
//
//        onView(withId(R.id.btn2))
//            .perform(click())
//        checkResult("12")
//
//        onView(withId(R.id.btn3))
//            .perform(click())
//        checkResult("123")
//
//        onView(withId(R.id.btnClear))
//            .perform(click())
//        checkResult("0")
//    }
//
//    private fun checkResult(text: String) {
//        onView(withId(R.id.tvResult))
//            .check(matches(withText(text)))
//    }
//}
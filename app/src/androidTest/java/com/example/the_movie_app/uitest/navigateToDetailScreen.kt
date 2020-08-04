package com.example.the_movie_app.uitest

import android.content.Intent
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import com.example.the_movie_app.R
import com.example.the_movie_app.activities.MainActivity
import com.example.the_movie_app.views.viewholders.PopularFilmsViewholder
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class navigateToDetailScreen {

    private val activityTestRule = ActivityTestRule<MainActivity>(MainActivity::class.java)

    @Before
    fun setUp(){
        activityTestRule.launchActivity(Intent())
    }

    @Test
    fun navigateToDetailScreen(){
        onView(withId(R.id.rvPopularFilms))
            .perform(RecyclerViewActions.actionOnItemAtPosition<PopularFilmsViewholder>(0,click()))

        onView(withId(R.id.btnBack))
            .check(matches(isDisplayed()))
    }

}
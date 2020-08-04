package com.example.the_movie_app.uitest

import android.content.Intent
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import com.example.the_movie_app.R
import com.example.the_movie_app.activities.MainActivity
import com.example.the_movie_app.activities.MovieDetailActivity
import com.example.the_movie_app.views.viewholders.PopularFilmsViewholder
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class navigateToMainScreen {

    private val activityTestRule = ActivityTestRule<MovieDetailActivity>(MovieDetailActivity::class.java)

    @Before
    fun setUp(){
        activityTestRule.launchActivity(Intent())
    }

    @Test
    fun navigateToDetailScreen(){
        Espresso.onView(ViewMatchers.withId(R.id.btnBack))
            .perform()

        Espresso.onView(ViewMatchers.withId(R.id.vpCategory))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

}
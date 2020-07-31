package com.example.the_movie_app.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.the_movie_app.R
import com.example.the_movie_app.adapters.recyclerviewadapters.*
import com.example.the_movie_app.adapters.viewpageradapters.CategoryViewPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_action_film.*
import kotlinx.android.synthetic.main.viewpod_best_actors.*
import kotlinx.android.synthetic.main.viewpod_showcase.*

class MainActivity : AppCompatActivity() {

    private lateinit var linearLayoutManagerReview : LinearLayoutManager
    private lateinit var linearLayoutManagerPopular : LinearLayoutManager
    private lateinit var linearLayoutManagerShowCases : LinearLayoutManager
    private lateinit var linearLayoutManagerBestActor : LinearLayoutManager
    private val mTrailerAdapter = MovieTrailerAdapter()
    private val mPopularFilmsAdapter = PopularFlimsAdapter()
    private val mShowCasesAdapter = ShowCasesAdapter()
    private val mBestActorAdapter = BestActorAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        linearLayoutManagerReview = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        linearLayoutManagerPopular = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        linearLayoutManagerShowCases = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        linearLayoutManagerBestActor = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        setUpViewPager()
        setUpRecyclerViews()
    }

    private fun setUpViewPager(){
        val vpCategoryAdapter = CategoryViewPagerAdapter(supportFragmentManager)
        vpCategory.adapter = vpCategoryAdapter
        tabCategory.setupWithViewPager(vpCategory)
    }

    private fun setUpRecyclerViews(){
        rvReview.layoutManager = linearLayoutManagerReview
        rvReview.adapter = mTrailerAdapter
        rvPopularFilms.layoutManager = linearLayoutManagerPopular
        rvPopularFilms.adapter = mPopularFilmsAdapter
        rvShowCases.layoutManager = linearLayoutManagerShowCases
        rvShowCases.adapter = mShowCasesAdapter
        rvBestActors.layoutManager = linearLayoutManagerBestActor
        rvBestActors.adapter = mBestActorAdapter
    }
}
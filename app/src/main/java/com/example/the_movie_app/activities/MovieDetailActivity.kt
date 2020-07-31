package com.example.the_movie_app.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.the_movie_app.R
import com.example.the_movie_app.adapters.recyclerviewadapters.ActorsAdapter
import kotlinx.android.synthetic.main.activity_movie_detail.*
import kotlinx.android.synthetic.main.activity_movie_detail.rvActors
import kotlinx.android.synthetic.main.viewpod_creators.*

class MovieDetailActivity : AppCompatActivity() {

    private lateinit var linearLayoutManagerActor : LinearLayoutManager
    private val mActorAdapter = ActorsAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)
        setUpRecyclerView()
    }

    private fun setUpRecyclerView(){
        rvActors.layoutManager = linearLayoutManagerActor
        rvActors.adapter = mActorAdapter
    }
}
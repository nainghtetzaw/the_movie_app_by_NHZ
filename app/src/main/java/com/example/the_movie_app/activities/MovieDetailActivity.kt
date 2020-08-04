package com.example.the_movie_app.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.the_movie_app.R
import com.example.the_movie_app.adapters.recyclerviewadapters.ActorsAdapter
import com.example.the_movie_app.adapters.recyclerviewadapters.CreatorAdapter
import com.example.the_movie_app.data.vos.ActorsVO
import com.example.the_movie_app.data.vos.MovieDetailVO
import com.example.the_movie_app.mvp.presenters.DetailPresenter
import com.example.the_movie_app.mvp.presenters.DetailPresenterImpl
import com.example.the_movie_app.mvp.views.DetailView
import com.example.the_movie_app.utils.BASE_IMG_URL
import com.example.the_movie_app.utils.MOVIE_RUNTIME_UNIT
import kotlinx.android.synthetic.main.activity_movie_detail.*
import kotlinx.android.synthetic.main.activity_movie_detail.rvActors
import kotlinx.android.synthetic.main.viewpod_about_film.*
import kotlinx.android.synthetic.main.viewpod_creators.*

class MovieDetailActivity : AppCompatActivity(),DetailView {

    private lateinit var linearLayoutManagerActor : LinearLayoutManager
    private lateinit var linearLayoutManagerCreator : LinearLayoutManager
    private val mActorAdapter = ActorsAdapter()
    private val mCreatorAdapter = CreatorAdapter()
    private lateinit var mPresenter : DetailPresenter

    companion object{
        const val MOVIE_ID = "MOVIE_ID"
        fun newIntent(context: Context,id : Int?) : Intent {
            val intent = Intent(context,MovieDetailActivity::class.java)
                .putExtra(MOVIE_ID,id)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)
        setUpPresenter()

        linearLayoutManagerActor = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        linearLayoutManagerCreator = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)

        val movieId = intent.getIntExtra(MOVIE_ID,0)

        mPresenter.onUiReady(this,this,movieId)

        setUpRecyclerView()
        navigateToMain()
    }

    private fun setUpRecyclerView(){
        rvActors.layoutManager = linearLayoutManagerActor
        rvActors.adapter = mActorAdapter

        rvCreators.layoutManager = linearLayoutManagerCreator
        rvCreators.adapter = mCreatorAdapter
    }

    private fun setUpPresenter(){
        mPresenter = ViewModelProviders.of(this).get(DetailPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    private fun navigateToMain() {
        btnBack.setOnClickListener {
            super.onBackPressed()
        }
    }

    override fun showActorsData(actors: MutableList<ActorsVO>) {
        mActorAdapter.setNewData(actors)
    }

    override fun showCreatorsData(creators: MutableList<ActorsVO>) {
        mCreatorAdapter.setNewData(creators)
    }

    override fun bindDetailData(detail: MovieDetailVO) {
        Glide.with(this)
            .load(BASE_IMG_URL+detail.posterPath)
            .into(imgMoviePoster)
        tvTitle.text = detail.title
        tvRating.text = detail.voteAverage.toString()
        tvMovieLength.text = detail.runtime.toString()+ MOVIE_RUNTIME_UNIT
        tvStorylineReview.text = detail.overview
        tvNumVotes.text = detail.voteCount.toString()

        tvMovieOriginalTitle.text =detail.originalTitle
        tvMovieDescription.text = detail.overview
        tvMoviePremiere.text = detail.releasesDate
    }
}
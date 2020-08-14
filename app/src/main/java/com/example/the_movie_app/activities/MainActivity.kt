package com.example.the_movie_app.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shared.activities.BaseActivity
import com.example.the_movie_app.R
import com.example.the_movie_app.adapters.recyclerviewadapters.*
import com.example.the_movie_app.adapters.viewpageradapters.DynamicPagerAdapter
import com.example.the_movie_app.data.vos.*
import com.example.the_movie_app.mvp.presenters.MainPresenter
import com.example.the_movie_app.mvp.presenters.MainPresenterImpl
import com.example.the_movie_app.mvp.views.MainView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.viewpod_best_actors.*
import kotlinx.android.synthetic.main.viewpod_showcase.*

class MainActivity : BaseActivity(),MainView {

    private lateinit var linearLayoutManagerReview : LinearLayoutManager
    private lateinit var linearLayoutManagerPopular : LinearLayoutManager
    private lateinit var linearLayoutManagerShowCases : LinearLayoutManager
    private lateinit var linearLayoutManagerBestActor : LinearLayoutManager
    private lateinit var mPopularFilmsAdapter : PopularFlimsAdapter
    private lateinit var mDynamicPagerAdapter: DynamicPagerAdapter
    private lateinit var mShowCasesAdapter : ShowCasesAdapter
    private lateinit var mBestActorAdapter : BestActorAdapter
    private lateinit var mTrailerAdapter : MovieTrailerAdapter
    private lateinit var mPresenter : MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpPresenter()

        linearLayoutManagerReview = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        linearLayoutManagerPopular = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        linearLayoutManagerShowCases = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        linearLayoutManagerBestActor = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        mPopularFilmsAdapter = PopularFlimsAdapter(mPresenter)
        mShowCasesAdapter = ShowCasesAdapter(mPresenter)
        mBestActorAdapter = BestActorAdapter(mPresenter)
        mTrailerAdapter = MovieTrailerAdapter(mPresenter)

        mPresenter.onUiReady(this,this)
        setUpRecyclerViews()
    }

    private fun setUpPresenter(){
        mPresenter = ViewModelProviders.of(this).get(MainPresenterImpl::class.java)
        mPresenter.initPresenter(this)
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

    override fun navigateToDetailScreen(id : Int?) {
        startActivity(MovieDetailActivity.newIntent(this,id))
    }

    override fun showPopularMovieData(popular: MutableList<PopularMovieVO>) {
        mPopularFilmsAdapter.setNewData(popular)
    }

    override fun showBestActorsData(actor: MutableList<ActorsVO>) {
        mBestActorAdapter.setNewData(actor)
    }

    override fun showNowPlayingMovieData(movie: MutableList<NowPlayingMoviesVO>) {
        mShowCasesAdapter.setNewData(movie)
    }

    override fun showMovieReviewData(movie: MutableList<MovieReviewVO>) {
        mTrailerAdapter.setNewData(movie)
    }

    override fun showMovieGenreData(genre: MutableList<MovieGenreVO>) {
        mDynamicPagerAdapter = DynamicPagerAdapter(supportFragmentManager,genre)
        vpCategory.adapter = mDynamicPagerAdapter
        tabCategory.setupWithViewPager(vpCategory)
    }

    override fun openMovieTrailer() {
        Toast.makeText(this,"Clicked",Toast.LENGTH_SHORT).show()
    }
}
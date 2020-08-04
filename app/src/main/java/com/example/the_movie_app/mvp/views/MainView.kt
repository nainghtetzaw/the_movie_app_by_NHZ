package com.example.the_movie_app.mvp.views

import com.example.the_movie_app.data.vos.*

interface MainView : BaseView {
    fun navigateToDetailScreen(id : Int?)
    fun showPopularMovieData(popular : MutableList<PopularMovieVO>)
    fun showBestActorsData(actor : MutableList<ActorsVO>)
    fun showNowPlayingMovieData(movie : MutableList<NowPlayingMoviesVO>)
    fun showMovieReviewData(movie : MutableList<MovieReviewVO>)
    fun showMovieGenreData(genre : MutableList<MovieGenreVO>)
    fun openMovieTrailer()
}
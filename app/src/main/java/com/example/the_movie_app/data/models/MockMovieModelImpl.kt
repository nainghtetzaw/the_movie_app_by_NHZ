package com.example.the_movie_app.data.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.the_movie_app.data.*
import com.example.the_movie_app.data.vos.*

object MockMovieModelImpl : MovieModel {
    override fun getAllPopularMovies(): LiveData<List<PopularMovieVO>> {
        val popularMovie = MutableLiveData<List<PopularMovieVO>>()
        popularMovie.postValue(getDummyPopularData())
        return popularMovie
    }

    override fun getAllPopularMoviesByGenreId(id: Int?): LiveData<List<PopularMovieVO>> {
        val popularMovie = MutableLiveData<List<PopularMovieVO>>()
        popularMovie.postValue(getDummyPopularData())
        return popularMovie
    }

    override fun getAllActors(): LiveData<List<ActorsVO>> {
        val actors = MutableLiveData<List<ActorsVO>>()
        actors.postValue(getDummyActorsData())
        return actors
    }

    override fun getAllNowPlayingMovies(): LiveData<List<NowPlayingMoviesVO>> {
        val nowPlayingMovies = MutableLiveData<List<NowPlayingMoviesVO>>()
        nowPlayingMovies.postValue(getDummyNowPlayingMovieData())
        return nowPlayingMovies
    }

    override fun getAllMovieGenre(): LiveData<List<MovieGenreVO>> {
        val movieGenre = MutableLiveData<List<MovieGenreVO>>()
        movieGenre.postValue(getDummyMovieGenreData())
        return movieGenre
    }

    override fun getAllMainDataAndSaveToDatabase(onSuccess: () -> Unit, onError: (String) -> Unit) {
        val popularMovie = MutableLiveData<List<PopularMovieVO>>()
        popularMovie.postValue(getDummyPopularData())

        val actors = MutableLiveData<List<ActorsVO>>()
        actors.postValue(getDummyActorsData())

        val nowPlayingMovies = MutableLiveData<List<NowPlayingMoviesVO>>()
        nowPlayingMovies.postValue(getDummyNowPlayingMovieData())

        val movieReview = MutableLiveData<List<MovieReviewVO>>()
        movieReview.postValue(getDummyMovieReviewData())
    }

    override fun getAllMovieDetail(id: Int): LiveData<MovieDetailVO> {
        val movieDetail = MutableLiveData<MovieDetailVO>()
        movieDetail.postValue(getDummyMovieDetailData())
        return movieDetail
    }

    override fun getAllMovieReview(): LiveData<List<MovieReviewVO>> {
        val movieReview = MutableLiveData<List<MovieReviewVO>>()
        movieReview.postValue(getDummyMovieReviewData())
        return movieReview
    }

    override fun getAllMovieDetailAndSaveToDatabase(id: Int?) {
        val movieDetail = MutableLiveData<MovieDetailVO>()
        movieDetail.postValue(getDummyMovieDetailData())
    }
}
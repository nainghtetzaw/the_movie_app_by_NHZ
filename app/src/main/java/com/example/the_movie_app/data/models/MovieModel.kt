package com.example.the_movie_app.data.models

import androidx.lifecycle.LiveData
import com.example.the_movie_app.data.vos.*

interface MovieModel {
    fun getAllPopularMovies() : LiveData<List<PopularMovieVO>>
    fun getAllPopularMoviesByGenreId(id: Int?) :LiveData<List<PopularMovieVO>>
    fun getAllActors() : LiveData<List<ActorsVO>>
    fun getAllNowPlayingMovies() : LiveData<List<NowPlayingMoviesVO>>
    fun getAllMovieGenre() : LiveData<List<MovieGenreVO>>
    fun getAllMovieReview() : LiveData<List<MovieReviewVO>>

    fun getAllMainDataAndSaveToDatabase(onSuccess: () -> Unit,onError: (String) -> Unit)

    fun getAllMovieDetail(id : Int) : LiveData<MovieDetailVO>
    fun getAllMovieDetailAndSaveToDatabase(id : Int?)
}
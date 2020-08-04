package com.example.the_movie_app.network

import com.example.the_movie_app.data.vos.MovieDetailVO
import com.example.the_movie_app.network.responces.*
import com.example.the_movie_app.utils.*
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi {

    @GET(GET_POPULAR_MOVIES)
    fun getPopularMovieResponse(@Query(API_KEY) apikey : String) : Observable<PopularMovieResponse>

    @GET("$GET_MOVIE_DETAIL/{MOVIE_ID}")
    fun getMovieDetailResponse(@Path("MOVIE_ID") movieId : Int?,@Query(API_KEY) apikey: String) : Observable<MovieDetailVO>

    @GET(GET_ACTORS)
    fun getActorsResponse(@Query(API_KEY) apikey: String) : Observable<ActorsResponse>

    @GET(GET_NOW_PLAYING_MOVIES)
    fun getNowPlayingMovieResponse(@Query(API_KEY) apikay : String) : Observable<NowPlayingMoviesResponse>

    @GET(GET_TOP_RATED)
    fun getMovieReviewResponse(@Query(API_KEY) apikey: String) : Observable<MovieReviewResponse>

    @GET(GET_MOVIE_GENRES)
    fun getMovieGenreResponse(@Query(API_KEY) apikey: String) : Observable<MovieGenreResponse>
}
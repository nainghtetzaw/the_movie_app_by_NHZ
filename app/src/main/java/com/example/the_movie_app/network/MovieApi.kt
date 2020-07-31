package com.example.the_movie_app.network

import com.example.the_movie_app.data.vos.MovieDetailVO
import com.example.the_movie_app.network.responces.ActorsResponse
import com.example.the_movie_app.network.responces.PopularMovieResponse
import com.example.the_movie_app.utils.GET_ACTORS
import com.example.the_movie_app.utils.GET_MOVIE_DETAIL
import com.example.the_movie_app.utils.GET_POPULAR_MOVIES
import com.example.the_movie_app.utils.PARAM_API_KEY
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi {

    @GET(GET_POPULAR_MOVIES)
    fun getPopularMovieResponse(@Query(PARAM_API_KEY) apikey : String) : Observable<PopularMovieResponse>

    @GET("$GET_MOVIE_DETAIL/{MOVIE_ID}")
    fun getMovieDetailResponse(@Query(PARAM_API_KEY) apikey: String , @Path("MOVIE_ID") movieId : Int) : Observable<MovieDetailVO>

    @GET(GET_ACTORS)
    fun getActorsResponse(@Query(PARAM_API_KEY) apikey: String) : Observable<ActorsResponse>
}
package com.example.the_movie_app.network.responces

import com.example.the_movie_app.data.vos.MovieReviewVO
import com.example.the_movie_app.data.vos.PopularMovieVO
import com.google.gson.annotations.SerializedName

data class MovieReviewResponse (
    @SerializedName("page") var page : Int = 0,
    @SerializedName("total_results") var totalResults : Int = 0,
    @SerializedName("total_pages") var totalPages : Int = 0,
    @SerializedName("results") var results :List<MovieReviewVO> = listOf()
)
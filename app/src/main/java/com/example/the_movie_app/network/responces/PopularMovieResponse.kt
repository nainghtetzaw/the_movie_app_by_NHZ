package com.example.the_movie_app.network.responces

import com.example.the_movie_app.data.vos.PopularMovieVO
import com.google.gson.annotations.SerializedName

data class PopularMovieResponse (
    @SerializedName("page") var page : Int = 0,
    @SerializedName("results") var results :List<PopularMovieVO> = listOf(),
    @SerializedName("total_results") var totalResults : Int = 0,
    @SerializedName("total_pages") var totalPages : Int = 0
)
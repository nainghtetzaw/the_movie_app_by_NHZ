package com.example.the_movie_app.network.responces

import com.example.the_movie_app.data.vos.NowPlayingMoviesVO
import com.example.the_movie_app.data.vos.dateVO
import com.google.gson.annotations.SerializedName

data class NowPlayingMoviesResponse (
    @SerializedName("results") var result : List<NowPlayingMoviesVO> = listOf(),
    @SerializedName("page") var page : Int = 0,
    @SerializedName("total_results") var totalResult : Int = 0,
    @SerializedName("dates") var dates : dateVO ?= null,
    @SerializedName("total_pages") var totalPages : Int = 0
)
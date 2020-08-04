package com.example.the_movie_app.network.responces

import com.example.the_movie_app.data.vos.MovieGenreVO
import com.google.gson.annotations.SerializedName

data class MovieGenreResponse (
    @SerializedName("genres") var genres : List<MovieGenreVO> = listOf()
)
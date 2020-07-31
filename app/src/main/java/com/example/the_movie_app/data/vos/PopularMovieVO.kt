package com.example.the_movie_app.data.vos

import androidx.room.Embedded
import androidx.room.Entity
import com.google.gson.annotations.SerializedName
import java.util.function.DoubleToLongFunction

@Entity(tableName = "Popular_Movies")
data class PopularMovieVO (
    @SerializedName("poster_path") var posterPath : String = "",
    @SerializedName("adult") var adult : Boolean = false,
    @SerializedName("overview") var overview : String = "",
    @SerializedName("release_date") var releaseDate : String = "",
    @SerializedName("id") var id : Int = 0,
    @SerializedName("original_title") var originalTitle : String = "",
    @SerializedName("original_language") var originalLangugage : String = "",
    @SerializedName("title") var title : String = "",
    @SerializedName("backdrop_path") var backdropPath : String = "",
    @SerializedName("popularity") var popularity : Double = 0.0,
    @SerializedName("vote_count") var voteCount : Int = 0,
    @SerializedName("video") var video : Boolean = false,
    @SerializedName("vote_average") var voteAverage : Double = 0.0,
    @SerializedName("genre_ids") var genreIds : ArrayList<Int> = arrayListOf()
)
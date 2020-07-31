package com.example.the_movie_app.data.vos


import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity(tableName = "Movie_Detail")
data class MovieDetailVO (
    @SerializedName("backdrop_path") var backdropPath : String = "",
    @SerializedName("homepage") var homepage : String = "",
    @SerializedName("id") var id : Int = 0,
    @SerializedName("original_title") var origianlTitle : String = "",
    @SerializedName("overview") var overview : String = "",
    @SerializedName("poster_path") var posterPath : String = "",
    @SerializedName("release_date") var releasesDate : String = "",
    @SerializedName("runtime") var runtime : Int = 0,
    @SerializedName("title") var title : String = "",
    @SerializedName("vote_average") var voteAverage : Double = 0.0,
    @SerializedName("vote_count") var voteCount : Int = 0
)
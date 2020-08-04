package com.example.the_movie_app.data.vos

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "Now_Playing_Movies")
data class NowPlayingMoviesVO (
    @PrimaryKey(autoGenerate = false)
    @SerializedName("id") var id : Int = 0,
    @SerializedName("original_title") var originalTitle : String = "",
    @SerializedName("release_date") var releasedDate : String = "",
    @SerializedName("poster_path") var posterPath : String = ""
)
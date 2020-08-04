package com.example.the_movie_app.data.vos

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "Movie_Top_Rated")
data class MovieReviewVO (
    @PrimaryKey(autoGenerate = false)
    @SerializedName("id") var id : Int = 0,
    @SerializedName("poster_path") var posterPath : String = "",
    @SerializedName("title") var title : String = ""
)
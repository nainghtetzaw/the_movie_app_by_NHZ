package com.example.the_movie_app.data.vos

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "Movie_Genre")
data class MovieGenreVO (
    @PrimaryKey(autoGenerate = false)
    @SerializedName("id") var id : Int = 0,
    @SerializedName("name") var name : String = ""
)
package com.example.the_movie_app.data.vos

import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity(tableName = "Actors")
data class ActorsVO (
    @SerializedName("profile_path") var profilePath : String = "",
    @SerializedName("name") var name : String = ""
)
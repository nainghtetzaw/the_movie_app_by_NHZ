package com.example.the_movie_app.data.vos

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "Actors")
data class ActorsVO (
    @PrimaryKey
    @SerializedName("name") var name : String = "",
    @SerializedName("profile_path") var profilePath : String = ""

)
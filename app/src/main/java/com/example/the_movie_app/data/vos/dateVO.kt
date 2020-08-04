package com.example.the_movie_app.data.vos

import com.google.gson.annotations.SerializedName

data class dateVO (
    @SerializedName("maximum") var maximum : String = "",
    @SerializedName("minimum") var minimum : String = ""
)
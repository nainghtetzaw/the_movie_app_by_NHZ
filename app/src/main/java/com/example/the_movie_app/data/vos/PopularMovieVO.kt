package com.example.the_movie_app.data.vos

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.the_movie_app.persistence.typeconverters.GenreIdTypeConverter
import com.google.gson.annotations.SerializedName
import java.util.function.DoubleToLongFunction

@Entity(tableName = "Popular_Movies")
@TypeConverters(GenreIdTypeConverter::class)
data class PopularMovieVO (
    @PrimaryKey(autoGenerate = false)
    @SerializedName("id") var id : Int = 0,
    @SerializedName("poster_path") var posterPath : String = "",
    @SerializedName("adult") var adult : Boolean = false,
    @SerializedName("overview") var overview : String = "",
    @SerializedName("release_date") var releaseDate : String = "",
    @SerializedName("original_title") var originalTitle : String = "",
    @SerializedName("title") var title : String = "",
    @SerializedName("vote_average") var voteAverage : Double = 0.0,
    @SerializedName("genre_ids") var genreIds : ArrayList<Int> = arrayListOf()
)
package com.example.the_movie_app.persistence.typeconverters

import androidx.room.TypeConverter
import com.example.the_movie_app.data.vos.PopularMovieVO
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class GenreIdTypeConverter {

    @TypeConverter
    fun toString(genreid : ArrayList<Int>) : String{
        return Gson().toJson(genreid)
    }

    @TypeConverter
    fun toArrayList(genreid: String) : ArrayList<Int>{
        val genreidType = object :TypeToken<ArrayList<Int>>(){}.type
        return Gson().fromJson(genreid,genreidType)
    }

}
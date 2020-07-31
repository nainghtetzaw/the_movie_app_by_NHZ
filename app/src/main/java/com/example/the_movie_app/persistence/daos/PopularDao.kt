package com.example.the_movie_app.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.the_movie_app.data.vos.PopularMovieVO

@Dao
interface PopularDao {

    @Query("SELECT * From Popular_Movies")
    fun getAllFromPopular() : LiveData<List<PopularMovieVO>>

    @Insert
    fun insertIntoPopular(popular : List<PopularMovieVO>)
}
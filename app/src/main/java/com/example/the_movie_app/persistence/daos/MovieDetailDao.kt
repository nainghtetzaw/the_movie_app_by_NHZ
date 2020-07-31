package com.example.the_movie_app.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.the_movie_app.data.vos.MovieDetailVO

@Dao
interface MovieDetailDao {

    @Query("SELECT * FROM Movie_Detail")
    fun getAllFromDetail() : LiveData<List<MovieDetailVO>>

    @Insert
    fun insertIntoDetail(movieDetail : List<MovieDetailVO>)
}
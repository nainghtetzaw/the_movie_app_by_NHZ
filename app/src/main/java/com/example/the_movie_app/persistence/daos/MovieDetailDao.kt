package com.example.the_movie_app.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.the_movie_app.data.vos.MovieDetailVO

@Dao
interface MovieDetailDao {

    @Query("SELECT * FROM Movie_Detail WHERE id =:id")
    fun getAllFromDetail(id : Int) : LiveData<MovieDetailVO>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertIntoDetail(movieDetail : MovieDetailVO)
}
package com.example.the_movie_app.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.the_movie_app.data.vos.MovieReviewVO

@Dao
interface MovieReviewDao {

    @Query("SELECT * FROM Movie_Top_Rated")
    fun getAllMovieReview() : LiveData<List<MovieReviewVO>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertIntoMovieReview(movie : List<MovieReviewVO>)
}
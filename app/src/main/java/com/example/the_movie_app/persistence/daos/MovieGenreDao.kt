package com.example.the_movie_app.persistence.daos

import android.graphics.Bitmap
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.the_movie_app.data.vos.MovieGenreVO

@Dao
interface MovieGenreDao {

    @Query("SELECT * FROM Movie_Genre")
    fun getAllFromMovieGenre() : LiveData<List<MovieGenreVO>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertIntoMovieGenre(genre : List<MovieGenreVO>)
}
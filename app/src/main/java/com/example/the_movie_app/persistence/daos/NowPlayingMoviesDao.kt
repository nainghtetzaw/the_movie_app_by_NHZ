package com.example.the_movie_app.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.the_movie_app.data.vos.NowPlayingMoviesVO

@Dao
interface NowPlayingMoviesDao {

    @Query("SELECT * FROM Now_Playing_Movies")
    fun getAllFromNowPlayingMovie() : LiveData<List<NowPlayingMoviesVO>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertIntoNowPlayingMovie(movie : List<NowPlayingMoviesVO>)
}
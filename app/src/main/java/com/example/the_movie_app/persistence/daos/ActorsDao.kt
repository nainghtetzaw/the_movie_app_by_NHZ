package com.example.the_movie_app.persistence.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.the_movie_app.data.vos.ActorsVO

@Dao
interface ActorsDao {

    @Query("SELECT * FROM Actors")
    fun getAllFromActors() : LiveData<List<ActorsVO>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertIntoActors(actor : List<ActorsVO>)
}
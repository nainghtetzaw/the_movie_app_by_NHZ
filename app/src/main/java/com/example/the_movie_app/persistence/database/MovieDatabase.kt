package com.example.the_movie_app.persistence.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.the_movie_app.data.vos.ActorsVO
import com.example.the_movie_app.data.vos.MovieDetailVO
import com.example.the_movie_app.data.vos.PopularMovieVO
import com.example.the_movie_app.persistence.daos.ActorsDao
import com.example.the_movie_app.persistence.daos.MovieDetailDao
import com.example.the_movie_app.persistence.daos.PopularDao

@Database(entities = [ActorsVO::class,MovieDetailVO::class,PopularMovieVO::class], version = 12,exportSchema = false)
abstract class MovieDatabase : RoomDatabase() {

companion object{

    val DB_NAME = "Movie_Database"
    var dbInstance : MovieDatabase ?= null

    fun getDbInstance(context: Context) : MovieDatabase{
        when(dbInstance){
            null -> {
                dbInstance = Room.databaseBuilder(context,MovieDatabase::class.java, DB_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
            }
        }
        return dbInstance!!
    }
}

    abstract fun popularDao() : PopularDao
    abstract fun movieDetailDao() : MovieDetailDao
    abstract fun actorsDao() : ActorsDao

}
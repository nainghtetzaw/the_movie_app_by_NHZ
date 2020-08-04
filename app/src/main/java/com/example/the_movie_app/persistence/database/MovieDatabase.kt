package com.example.the_movie_app.persistence.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.the_movie_app.data.vos.*
import com.example.the_movie_app.persistence.daos.*

@Database(entities = [ActorsVO::class,MovieDetailVO::class,PopularMovieVO::class,NowPlayingMoviesVO::class,MovieReviewVO::class,MovieGenreVO::class], version = 21,exportSchema = false)
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
    abstract fun nowPlayingMoviesDao() : NowPlayingMoviesDao
    abstract fun movieReviewDao() : MovieReviewDao
    abstract fun movieGenreDao() : MovieGenreDao
}
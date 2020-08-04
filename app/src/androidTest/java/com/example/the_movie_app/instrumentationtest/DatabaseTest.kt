package com.example.the_movie_app.instrumentationtest

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.example.the_movie_app.data.getDummyMovieDetailData
import com.example.the_movie_app.data.getDummyPopularData
import com.example.the_movie_app.persistence.daos.*
import com.example.the_movie_app.persistence.database.MovieDatabase
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class DatabaseTest  {

    private lateinit var db : MovieDatabase
    private lateinit var actorDao : ActorsDao
    private lateinit var popularDao : PopularDao
    private lateinit var movieReviewDao : MovieReviewDao
    private lateinit var movieDetailDao : MovieDetailDao
    private lateinit var nowPlayingMovieDao : NowPlayingMoviesDao

    @Before
    fun setUpDatabase(){
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(context,MovieDatabase::class.java).build()
        actorDao = db.actorsDao()
        popularDao = db.popularDao()
        movieReviewDao = db.movieReviewDao()
        movieDetailDao = db.movieDetailDao()
        nowPlayingMovieDao = db.nowPlayingMoviesDao()
    }

    @After
    fun closeDatabase(){
        db.close()
    }

    @Test
    fun insertDataIntoPopularDao(){
        popularDao.insertIntoPopular(getDummyPopularData())
    }

    @Test
    fun insertDataIntoMovieDetailDao(){
        movieDetailDao.insertIntoDetail(getDummyMovieDetailData())
        assert(movieDetailDao.getAllFromDetail(0).value?.id==0)
    }
}
package com.example.the_movie_app

import android.app.Application
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import com.example.the_movie_app.data.models.MovieModelImpl
import com.example.the_movie_app.workers.MovieWorker

class MovieApp : Application() {

    override fun onCreate() {
        super.onCreate()
        MovieModelImpl.initDatabase(applicationContext)
        getMovieOneTime()
    }

    private fun getMovieOneTime(){
        val getEventsWorkRequest = OneTimeWorkRequest
            .Builder(MovieWorker::class.java)
            .build()
        WorkManager.getInstance(applicationContext)
            .enqueue(getEventsWorkRequest)
    }
}
package com.example.the_movie_app.workers

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.example.the_movie_app.data.models.MovieModel
import com.example.the_movie_app.data.models.MovieModelImpl

abstract class BaseMovieWorker(context: Context, workerParam : WorkerParameters) : Worker(context,workerParam) {

    val mMovieModel : MovieModel = MovieModelImpl
}
package com.example.the_movie_app.workers

import android.content.Context
import androidx.work.WorkerParameters

class MovieWorker(context: Context,workerParam : WorkerParameters) : BaseMovieWorker(context,workerParam) {
    override fun doWork(): Result {
        var result = Result.failure()

        mMovieModel.getAllMainDataAndSaveToDatabase(
            onSuccess ={
                result = Result.success()
            },
            onError = {
                result = Result.failure()
            }
        )
        return result
    }


}
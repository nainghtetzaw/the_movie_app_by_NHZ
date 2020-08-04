package com.example.the_movie_app.data.models

import android.content.Context
import com.example.the_movie_app.network.MovieApi
import com.example.the_movie_app.persistence.database.MovieDatabase
import com.example.the_movie_app.utils.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit

abstract class BaseModel {

    protected var mMovieApi : MovieApi
    protected lateinit var mMovieDB : MovieDatabase

    init {
        val mOkHttpClient = OkHttpClient.Builder()
            .connectTimeout(15,TimeUnit.SECONDS)
            .readTimeout(15,TimeUnit.SECONDS)
            .writeTimeout(15,TimeUnit.SECONDS)
            .build()

        val mRetrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(mOkHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

        mMovieApi = mRetrofit.create(MovieApi::class.java)
    }

    fun initDatabase(context: Context){
        mMovieDB = MovieDatabase.getDbInstance(context)
    }

}
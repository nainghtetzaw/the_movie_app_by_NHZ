package com.example.the_movie_app.mvp.presenters

import android.content.Context
import androidx.lifecycle.LifecycleOwner
import com.example.the_movie_app.delegates.MovieDelegate
import com.example.the_movie_app.mvp.views.MainView

interface MainPresenter : MovieDelegate,BasePresenter<MainView> {

    fun onUiReady(lifecycleOwner: LifecycleOwner,context: Context)

}
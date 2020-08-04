package com.example.the_movie_app.mvp.presenters

import android.content.Context
import androidx.lifecycle.LifecycleOwner
import com.example.the_movie_app.delegates.DetailDelegate
import com.example.the_movie_app.mvp.views.DetailView

interface DetailPresenter : DetailDelegate,BasePresenter<DetailView> {
    fun onUiReady(lifecycleOwner: LifecycleOwner,context: Context,id : Int)
}
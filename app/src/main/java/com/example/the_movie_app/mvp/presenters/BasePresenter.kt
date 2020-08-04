package com.example.the_movie_app.mvp.presenters

import android.view.View
import com.example.the_movie_app.mvp.views.BaseView

interface BasePresenter <T : BaseView> {

    fun initPresenter(view : T)
}
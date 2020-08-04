package com.example.the_movie_app.mvp.presenters

import androidx.lifecycle.ViewModel
import com.example.the_movie_app.mvp.views.BaseView

abstract class AbstractBasePresenter<V : BaseView> : BasePresenter<V>,ViewModel() {

    var mView : V ?= null

    override fun initPresenter(view: V) {
        mView = view
    }

}
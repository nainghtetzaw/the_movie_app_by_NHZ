package com.example.the_movie_app.mvp.presenters

import android.content.Context
import android.view.View
import android.view.Window
import android.widget.Toast
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.example.the_movie_app.data.models.MovieModel
import com.example.the_movie_app.data.models.MovieModelImpl
import com.example.the_movie_app.mvp.views.CategoryView
import com.google.android.material.snackbar.Snackbar

class CategoryPresenterImpl : AbstractBasePresenter<CategoryView>() , CategoryPresenter {

    private val mModel : MovieModel = MovieModelImpl

    override fun onUiReady(lifecycleOwner: LifecycleOwner) {
        mModel.getAllPopularMovies().observe(lifecycleOwner, Observer {
                mView?.showCategoryData(it.toMutableList())
        })
    }

    override fun onTapPlayImg() {

    }

    override fun onTapMovieItem(id: Int) {
        mView?.navigateToMovieDetail(id)
    }

}
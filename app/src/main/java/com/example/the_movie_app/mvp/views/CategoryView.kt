package com.example.the_movie_app.mvp.views

import com.example.the_movie_app.data.vos.PopularMovieVO

interface CategoryView : BaseView {

    fun navigateToMovieDetail(id : Int)
    fun showCategoryData(data : MutableList<PopularMovieVO>)

}
package com.example.the_movie_app.mvp.views

import com.example.the_movie_app.data.vos.ActorsVO
import com.example.the_movie_app.data.vos.MovieDetailVO

interface DetailView : BaseView{
    fun showActorsData(actors : MutableList<ActorsVO>)
    fun showCreatorsData(creators : MutableList<ActorsVO>)
    fun bindDetailData(detail : MovieDetailVO)
}
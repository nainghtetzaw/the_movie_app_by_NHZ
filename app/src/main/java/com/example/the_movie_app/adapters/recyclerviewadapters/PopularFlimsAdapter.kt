package com.example.the_movie_app.adapters.recyclerviewadapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.the_movie_app.R
import com.example.the_movie_app.data.vos.PopularMovieVO
import com.example.the_movie_app.delegates.MovieDelegate
import com.example.the_movie_app.views.viewholders.baseviewholders.BasePopularFilmViewHolder
import com.example.the_movie_app.views.viewholders.PopularFilmsViewholder

class PopularFlimsAdapter(delegate: MovieDelegate) : BaseAdapter<BasePopularFilmViewHolder,PopularMovieVO>() {

    private val mDelegate : MovieDelegate = delegate

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BasePopularFilmViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_popular_films_and_serials,parent,false)
        return PopularFilmsViewholder(view,mDelegate)
    }

}
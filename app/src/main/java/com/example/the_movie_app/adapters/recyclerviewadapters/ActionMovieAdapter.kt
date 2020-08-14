package com.example.the_movie_app.adapters.recyclerviewadapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.shared.adapters.BaseAdapter
import com.example.the_movie_app.R
import com.example.the_movie_app.data.vos.PopularMovieVO
import com.example.the_movie_app.delegates.MovieDelegate
import com.example.the_movie_app.views.viewholders.ActionViewholder
import com.example.the_movie_app.views.viewholders.baseviewholders.BaseActionViewHoler

class ActionMovieAdapter(val delegate : MovieDelegate) : BaseAdapter<BaseActionViewHoler, PopularMovieVO>() {

    private val mDelegate : MovieDelegate = delegate

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActionViewholder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_category,parent,false)
        return ActionViewholder(view,mDelegate)
    }
}
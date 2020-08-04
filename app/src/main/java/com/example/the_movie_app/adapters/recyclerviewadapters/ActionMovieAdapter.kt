package com.example.the_movie_app.adapters.recyclerviewadapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.the_movie_app.R
import com.example.the_movie_app.data.vos.PopularMovieVO
import com.example.the_movie_app.views.viewholders.ActionViewholder
import com.example.the_movie_app.views.viewholders.baseviewholders.BaseActionViewHoler

class ActionMovieAdapter : BaseAdapter<BaseActionViewHoler,PopularMovieVO>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActionViewholder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_category,parent,false)
        return ActionViewholder(view)
    }
}
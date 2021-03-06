package com.example.the_movie_app.adapters.recyclerviewadapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.shared.adapters.BaseAdapter
import com.example.the_movie_app.R
import com.example.the_movie_app.data.vos.ActorsVO
import com.example.the_movie_app.delegates.MovieDelegate
import com.example.the_movie_app.views.viewholders.baseviewholders.BaseBestActorsViewHolder
import com.example.the_movie_app.views.viewholders.BestActorViewholder

class BestActorAdapter(delegate: MovieDelegate) : BaseAdapter<BaseBestActorsViewHolder, ActorsVO>() {

    private val mDelegate : MovieDelegate = delegate

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseBestActorsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_people,parent,false)
        return BestActorViewholder(view,mDelegate)
    }
}
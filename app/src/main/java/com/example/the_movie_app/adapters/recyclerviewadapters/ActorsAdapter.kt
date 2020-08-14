package com.example.the_movie_app.adapters.recyclerviewadapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.shared.adapters.BaseAdapter
import com.example.the_movie_app.R
import com.example.the_movie_app.data.vos.ActorsVO
import com.example.the_movie_app.views.viewholders.ActorsViewHolder
import com.example.the_movie_app.views.viewholders.baseviewholders.BaseActorViewHolder

class ActorsAdapter : BaseAdapter<BaseActorViewHolder, ActorsVO>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActorsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_people,parent,false)
        return ActorsViewHolder(view)
    }
}
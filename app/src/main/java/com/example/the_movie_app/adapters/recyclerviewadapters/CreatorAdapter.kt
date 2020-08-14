package com.example.the_movie_app.adapters.recyclerviewadapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.shared.adapters.BaseAdapter
import com.example.the_movie_app.R
import com.example.the_movie_app.data.vos.ActorsVO
import com.example.the_movie_app.views.viewholders.CreatorViewHolder
import com.example.the_movie_app.views.viewholders.baseviewholders.BaseCreatorViewHolder

class CreatorAdapter : BaseAdapter<BaseCreatorViewHolder, ActorsVO>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseCreatorViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_people,parent,false)
        return CreatorViewHolder(view)
    }
}
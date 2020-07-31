package com.example.the_movie_app.adapters.recyclerviewadapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.the_movie_app.R
import com.example.the_movie_app.views.viewholders.ActorsViewHolder
import com.example.the_movie_app.views.viewholders.BaseViewHolder

class ActorsAdapter : BaseAdapter() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_people,parent,false)
        return ActorsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 5
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {

    }
}
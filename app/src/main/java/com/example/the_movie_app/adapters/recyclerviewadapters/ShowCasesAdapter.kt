package com.example.the_movie_app.adapters.recyclerviewadapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.shared.adapters.BaseAdapter
import com.example.the_movie_app.R
import com.example.the_movie_app.data.vos.NowPlayingMoviesVO
import com.example.the_movie_app.delegates.MovieDelegate
import com.example.the_movie_app.views.viewholders.baseviewholders.BaseShowCasesViewHolder
import com.example.the_movie_app.views.viewholders.ShowCasesViewholder

class ShowCasesAdapter(delegate: MovieDelegate) : BaseAdapter<BaseShowCasesViewHolder, NowPlayingMoviesVO>() {

    private val mDelegate : MovieDelegate = delegate

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseShowCasesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_showcases,parent,false)
        return ShowCasesViewholder(view,mDelegate)
    }
}
package com.example.the_movie_app.adapters.recyclerviewadapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.the_movie_app.R
import com.example.the_movie_app.data.vos.MovieReviewVO
import com.example.the_movie_app.delegates.MovieDelegate
import com.example.the_movie_app.views.viewholders.MovieTrailerViewHolder
import com.example.the_movie_app.views.viewholders.baseviewholders.BaseMovieTrailerViewHolder

class MovieTrailerAdapter(delegate: MovieDelegate) : BaseAdapter<BaseMovieTrailerViewHolder,MovieReviewVO>() {

    private val mDelegate : MovieDelegate = delegate

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieTrailerViewHolder{
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie_review,parent,false)
        return MovieTrailerViewHolder(view,mDelegate)
    }
}
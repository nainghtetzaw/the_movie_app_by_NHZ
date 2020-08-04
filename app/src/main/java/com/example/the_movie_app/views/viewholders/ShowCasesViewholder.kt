package com.example.the_movie_app.views.viewholders

import android.view.View
import com.bumptech.glide.Glide
import com.example.the_movie_app.data.vos.NowPlayingMoviesVO
import com.example.the_movie_app.delegates.MovieDelegate
import com.example.the_movie_app.utils.BASE_IMG_URL
import com.example.the_movie_app.views.viewholders.baseviewholders.BaseShowCasesViewHolder
import kotlinx.android.synthetic.main.item_showcases.view.*

class ShowCasesViewholder(itemview : View,delegate: MovieDelegate) : BaseShowCasesViewHolder(itemview) {

    override fun bindData(data: NowPlayingMoviesVO) {
        mData = data
        Glide.with(itemView.context)
            .load(BASE_IMG_URL+data.posterPath)
            .into(itemView.imgShowCase)

        itemView.tvMovieName.text = data.originalTitle
        itemView.tvMovieReleasedDate.text = data.releasedDate
    }
}
package com.example.the_movie_app.views.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.the_movie_app.data.vos.MovieReviewVO
import com.example.the_movie_app.delegates.MovieDelegate
import com.example.the_movie_app.utils.BASE_IMG_URL
import com.example.the_movie_app.views.viewholders.baseviewholders.BaseMovieTrailerViewHolder
import kotlinx.android.synthetic.main.item_movie_review.view.*

class MovieTrailerViewHolder(itemview : View,delegate: MovieDelegate) : BaseMovieTrailerViewHolder(itemview) {
    override fun bindData(data: MovieReviewVO) {
        mData = data
        Glide.with(itemView.context)
            .load(BASE_IMG_URL+data.posterPath)
            .into(itemView.imgReviewPoster)
        itemView.tvMovieReviewName.text = data.title
    }
}
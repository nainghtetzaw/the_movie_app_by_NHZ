package com.example.the_movie_app.views.viewholders

import android.view.View
import com.bumptech.glide.Glide
import com.example.the_movie_app.data.vos.PopularMovieVO
import com.example.the_movie_app.delegates.MovieDelegate
import com.example.the_movie_app.utils.BASE_IMG_URL
import com.example.the_movie_app.views.viewholders.baseviewholders.BaseActionViewHoler
import kotlinx.android.synthetic.main.item_category.view.*

class ActionViewholder(itemview : View,delegate : MovieDelegate) : BaseActionViewHoler(itemview) {

    init {
        itemview.setOnClickListener {
            mData?.let {
                delegate.onTapMovieItem(it.id)
            }
        }
    }

    override fun bindData(data: PopularMovieVO) {
        mData = data
        Glide.with(itemView.context)
            .load(BASE_IMG_URL + data.posterPath)
            .into(itemView.imgPopularFilm)

        itemView.tvFilmName.text = data.title
        itemView.tvFilmRating.text = data.voteAverage.toString()
    }
}
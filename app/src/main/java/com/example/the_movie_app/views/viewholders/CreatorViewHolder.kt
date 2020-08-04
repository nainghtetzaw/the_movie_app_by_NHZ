package com.example.the_movie_app.views.viewholders

import android.view.View
import com.bumptech.glide.Glide
import com.example.the_movie_app.data.vos.ActorsVO
import com.example.the_movie_app.utils.BASE_IMG_URL
import com.example.the_movie_app.views.viewholders.baseviewholders.BaseCreatorViewHolder
import kotlinx.android.synthetic.main.item_people.view.*

class CreatorViewHolder(itemview : View) : BaseCreatorViewHolder(itemview) {
    override fun bindData(data: ActorsVO) {
        Glide.with(itemView.context)
            .load(BASE_IMG_URL+data.profilePath)
            .into(itemView.imgPeople)
        itemView.tvActorName.text = data.name
    }
}
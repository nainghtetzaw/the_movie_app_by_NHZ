package com.example.the_movie_app.adapters.recyclerviewadapters

import androidx.recyclerview.widget.RecyclerView
import com.example.the_movie_app.views.viewholders.baseviewholders.BaseViewHolder

abstract class BaseAdapter<T : BaseViewHolder<W>,W> : RecyclerView.Adapter<T>() {

    var mData : MutableList<W> = mutableListOf()

    override fun getItemCount(): Int {
        return mData.count()
    }

    override fun onBindViewHolder(holder: T, position: Int) {
        holder.bindData(mData[position])
    }

    fun setNewData(data : MutableList<W>){
        mData = data
        notifyDataSetChanged()
    }

}
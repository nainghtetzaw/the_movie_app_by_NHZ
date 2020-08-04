package com.example.the_movie_app.mvp.presenters

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.example.the_movie_app.data.models.MovieModel
import com.example.the_movie_app.data.models.MovieModelImpl
import com.example.the_movie_app.mvp.views.DetailView

class DetailPresenterImpl : AbstractBasePresenter<DetailView>(),DetailPresenter {

    var mModel : MovieModel = MovieModelImpl

    override fun onUiReady(lifecycleOwner: LifecycleOwner, context: Context,id: Int) {
        getNetworkCall(id)
        getData(lifecycleOwner,context,id)
    }

    private fun getData(lifecycleOwner: LifecycleOwner,context: Context,id: Int) {
        mModel.getAllMovieDetail(id).observe(lifecycleOwner, Observer {
            if(it == null){
                Toast.makeText(context,"No Data",Toast.LENGTH_SHORT).show()
            }else{
                mView?.bindDetailData(it)
            }
        })
        mModel.getAllActors().observe(lifecycleOwner, Observer {
            if(it.isNotEmpty()){
                mView?.showActorsData(it.toMutableList())
                mView?.showCreatorsData(it.toMutableList())
            }else{
                Toast.makeText(context,"No Data",Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun getNetworkCall(id : Int?){
        mModel.getAllMovieDetailAndSaveToDatabase(id)
    }
}
package com.example.the_movie_app.mvp.presenters

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.example.the_movie_app.data.models.MovieModel
import com.example.the_movie_app.data.models.MovieModelImpl
import com.example.the_movie_app.delegates.MovieDelegate
import com.example.the_movie_app.mvp.views.MainView

class MainPresenterImpl : AbstractBasePresenter<MainView>(),MainPresenter {

    var mModel : MovieModel = MovieModelImpl

    override fun onUiReady(lifecycleOwner: LifecycleOwner,context: Context) {
        getNetworkCall()
        getData(lifecycleOwner,context)
    }

    override fun onTapPlayImg() {
        mView?.openMovieTrailer()
    }

    override fun onTapMovieItem(id : Int?) {
        mView?.navigateToDetailScreen(id)
    }

    private fun getData(lifecycleOwner: LifecycleOwner,context: Context){
        mModel.getAllActors().observe(lifecycleOwner, Observer {
            if(it.isNotEmpty()){
                mView?.showBestActorsData(it.toMutableList())
            }
            else{
                Toast.makeText(context,"No Data",Toast.LENGTH_SHORT).show()
            }
        })
        mModel.getAllPopularMovies().observe(lifecycleOwner, Observer {
            if(it.isNotEmpty()){
                mView?.showPopularMovieData(it.toMutableList())
            }else{
                Toast.makeText(context,"No Data",Toast.LENGTH_SHORT).show()
            }
        })
        mModel.getAllNowPlayingMovies().observe(lifecycleOwner, Observer {
            if(it.isNotEmpty()){
                mView?.showNowPlayingMovieData(it.toMutableList())
            }else{
                Toast.makeText(context,"No Data",Toast.LENGTH_SHORT).show()
            }
        })
        mModel.getAllMovieReview().observe(lifecycleOwner, Observer {
            if(it.isNotEmpty()){
                mView?.showMovieReviewData(it.toMutableList())
            }else{
                Toast.makeText(context,"No Data",Toast.LENGTH_SHORT).show()
            }
        })
        mModel.getAllMovieGenre().observe(lifecycleOwner, Observer {
            if (it.isNotEmpty()){
                mView?.showMovieGenreData(it.toMutableList())
            }else{
                Toast.makeText(context,"No Data",Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun getNetworkCall(){
        mModel.getAllMainDataAndSaveToDatabase(onSuccess = {},onError = {})
    }
}
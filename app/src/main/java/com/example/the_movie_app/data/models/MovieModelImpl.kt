package com.example.the_movie_app.data.models

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.the_movie_app.data.vos.*
import com.example.the_movie_app.utils.PARAM_API_KEY
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Function
import io.reactivex.functions.Function4
import io.reactivex.functions.Function5
import io.reactivex.schedulers.Schedulers

object MovieModelImpl : BaseModel(),MovieModel {

    private fun getPopularMovieDataFromNetwork() : Observable<List<PopularMovieVO>>{
        return mMovieApi
            .getPopularMovieResponse(PARAM_API_KEY)
            .map { it.results }
            .subscribeOn(Schedulers.io())
    }

    private fun getActorDataFromNetwork() : Observable<List<ActorsVO>>{
        return mMovieApi
            .getActorsResponse(PARAM_API_KEY)
            .map { it.results }
            .subscribeOn(Schedulers.io())
    }

    private fun getNowPlayingMoviesFromNetwork() : Observable<List<NowPlayingMoviesVO>>{
        return mMovieApi
            .getNowPlayingMovieResponse(PARAM_API_KEY)
            .map { it.result }
            .subscribeOn(Schedulers.io())
    }

    private fun getMovieReviewFromNetwork() : Observable<List<MovieReviewVO>>{
        return mMovieApi
            .getMovieReviewResponse(PARAM_API_KEY)
            .map { it.results }
            .subscribeOn(Schedulers.io())
    }

    private fun getMovieGenreFromNetwork() : Observable<List<MovieGenreVO>>{
        return mMovieApi
            .getMovieGenreResponse(PARAM_API_KEY)
            .map { it.genres }
            .subscribeOn(Schedulers.io())
    }

    override fun getAllPopularMovies(): LiveData<List<PopularMovieVO>> {
        return mMovieDB.popularDao().getAllFromPopular()
    }

    override fun getAllPopularMoviesByGenreId(id: Int?): LiveData<List<PopularMovieVO>> {
        return mMovieDB.popularDao().getAllFromPopularById(id)
    }

    override fun getAllActors(): LiveData<List<ActorsVO>> {
        return mMovieDB.actorsDao().getAllFromActors()
    }

    override fun getAllNowPlayingMovies(): LiveData<List<NowPlayingMoviesVO>> {
        return mMovieDB.nowPlayingMoviesDao().getAllFromNowPlayingMovie()
    }

    override fun getAllMovieGenre(): LiveData<List<MovieGenreVO>> {
        return mMovieDB.movieGenreDao().getAllFromMovieGenre()
    }

    override fun getAllMainDataAndSaveToDatabase(onSuccess: () -> Unit,onError: (String) -> Unit ) {
        var movieAndActorList : MutableLiveData<MainVO> = MutableLiveData()
        Observable.zip<List<PopularMovieVO>,List<ActorsVO>,List<NowPlayingMoviesVO>,List<MovieReviewVO>,List<MovieGenreVO>,MainVO>(
            getPopularMovieDataFromNetwork(),
            getActorDataFromNetwork(),
            getNowPlayingMoviesFromNetwork(),
            getMovieReviewFromNetwork(),
            getMovieGenreFromNetwork(),
            Function5 { popular, actor, nowplaying, toprated,genre ->
                return@Function5 MainVO(popular, actor , nowplaying, toprated,genre)
            }
        )
            .doOnNext {
                mMovieDB.popularDao().insertIntoPopular(it.popular)
                mMovieDB.actorsDao().insertIntoActors(it.actor)
                mMovieDB.nowPlayingMoviesDao().insertIntoNowPlayingMovie(it.nowPlayingMovie)
                mMovieDB.movieReviewDao().insertIntoMovieReview(it.topRated)
                mMovieDB.movieGenreDao().insertIntoMovieGenre(it.genre)
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe ({
                movieAndActorList.postValue(it)
            },{
                Log.e("error", it.localizedMessage)
                onError(it.localizedMessage ?: "Network connection fail")
            })
    }

    override fun getAllMovieDetail(id: Int): LiveData<MovieDetailVO> {
        return mMovieDB.movieDetailDao().getAllFromDetail(id)
    }

    override fun getAllMovieReview(): LiveData<List<MovieReviewVO>> {
        return mMovieDB.movieReviewDao().getAllMovieReview()
    }

    override fun getAllMovieDetailAndSaveToDatabase(id: Int?) {
        mMovieApi.getMovieDetailResponse(id, PARAM_API_KEY)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe{
                mMovieDB.movieDetailDao().insertIntoDetail(it)
            }
    }
}
package com.example.the_movie_app.presenters

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.the_movie_app.activities.MainActivity
import com.example.the_movie_app.data.models.MockMovieModelImpl
import com.example.the_movie_app.data.models.MovieModel
import com.example.the_movie_app.data.models.MovieModelImpl
import com.example.the_movie_app.data.vos.PopularMovieVO
import com.example.the_movie_app.mvp.presenters.MainPresenterImpl
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(manifest = Config.NONE)
class MainPresenterImplTest {

    private lateinit var mPresenter : MainPresenterImpl

    @RelaxedMockK
    private lateinit var mView : MainActivity

    private lateinit var mModel : MovieModel

    @Before
    fun setUp(){

        MockKAnnotations.init(this)
        MovieModelImpl
        mModel = MockMovieModelImpl

        mPresenter = MainPresenterImpl()
        mPresenter.initPresenter(mView)
        mPresenter.mModel = this.mModel
    }

    @Test
    fun onTapPupularItem_navigateToMovieDetailScreen() {
        val popularMovie = PopularMovieVO()
        popularMovie.title = "Outpost"
        popularMovie.id = 5
        popularMovie.adult = false
        popularMovie.voteAverage = 1.49

        mPresenter.onTapMovieItem(popularMovie.id)
        verify {
            mView.navigateToDetailScreen(popularMovie.id)
        }
    }

}
package com.example.the_movie_app.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.the_movie_app.R
import com.example.the_movie_app.activities.MovieDetailActivity
import com.example.the_movie_app.adapters.recyclerviewadapters.ActionMovieAdapter
import com.example.the_movie_app.data.models.MovieModel
import com.example.the_movie_app.data.models.MovieModelImpl
import com.example.the_movie_app.data.vos.MovieGenreVO
import com.example.the_movie_app.data.vos.PopularMovieVO
import com.example.the_movie_app.mvp.presenters.CategoryPresenter
import com.example.the_movie_app.mvp.presenters.CategoryPresenterImpl
import com.example.the_movie_app.mvp.views.CategoryView
import kotlinx.android.synthetic.main.fragment_action_film.*
import java.lang.reflect.Array.getInt

private const val ARG_PARAM1 = "movie_id"

class ActionFilmFragment : Fragment(),CategoryView {

    private var movie_id: Int? = null
    private val mModel : MovieModel = MovieModelImpl
    private lateinit var mActionViewAdapter : ActionMovieAdapter
    private lateinit var linearLayoutManagerAction : LinearLayoutManager
    private lateinit var mPresenter : CategoryPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        linearLayoutManagerAction = LinearLayoutManager(activity?.applicationContext,LinearLayoutManager.HORIZONTAL,false)
        setUpPresenter()
        setUpRecyclerView()

        mPresenter.onUiReady(this)
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_action_film, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ActionFilmFragment.
         */
        @JvmStatic
        fun newInstance(genreid : Int) =
            ActionFilmFragment().apply {
                arguments = Bundle().apply {
                        putInt(ARG_PARAM1,genreid)
                }
            }
    }

    private fun setUpRecyclerView(){
        mActionViewAdapter = ActionMovieAdapter(mPresenter)
        rvAction.layoutManager = linearLayoutManagerAction
        rvAction.adapter = mActionViewAdapter
    }

    private fun setUpPresenter(){
        mPresenter = ViewModelProviders.of(this).get(CategoryPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    override fun navigateToMovieDetail(id: Int) {
        startActivity(MovieDetailActivity.newIntent(activity?.applicationContext,id))
    }

    override fun showCategoryData(data: MutableList<PopularMovieVO>) {
        mActionViewAdapter.setNewData(data)
    }

}
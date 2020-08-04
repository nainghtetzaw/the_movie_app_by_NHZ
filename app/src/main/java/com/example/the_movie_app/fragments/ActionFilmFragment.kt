package com.example.the_movie_app.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.the_movie_app.R
import com.example.the_movie_app.adapters.recyclerviewadapters.ActionMovieAdapter
import com.example.the_movie_app.data.models.MovieModel
import com.example.the_movie_app.data.models.MovieModelImpl
import com.example.the_movie_app.data.vos.MovieGenreVO
import com.example.the_movie_app.data.vos.PopularMovieVO
import kotlinx.android.synthetic.main.fragment_action_film.*
import java.lang.reflect.Array.getInt

private const val ARG_PARAM1 = "movie_id"

class ActionFilmFragment : Fragment() {

    private var movie_id: Int? = null
    private val mModel : MovieModel = MovieModelImpl
    private val mActionViewAdapter = ActionMovieAdapter()
    private lateinit var linearLayoutManagerAction : LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        linearLayoutManagerAction = LinearLayoutManager(activity?.applicationContext,LinearLayoutManager.HORIZONTAL,false)

        arguments?.let {
            movie_id = it.getInt(ARG_PARAM1)
        }
        setUpRecyclerView()
        getDataFromPopularVO()
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

    private fun showData(data : List<PopularMovieVO>){
        mActionViewAdapter.setNewData(data.toMutableList())
    }

    private fun setUpRecyclerView(){
        rvAction.layoutManager = linearLayoutManagerAction
        rvAction.adapter = mActionViewAdapter
    }

    private fun getDataFromPopularVO(){
        mModel.getAllPopularMoviesByGenreId(movie_id).observe(this, Observer {
            showData(it)
        })
    }
}
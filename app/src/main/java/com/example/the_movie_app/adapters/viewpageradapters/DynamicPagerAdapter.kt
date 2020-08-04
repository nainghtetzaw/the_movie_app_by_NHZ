package com.example.the_movie_app.adapters.viewpageradapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.the_movie_app.data.vos.MovieGenreVO
import com.example.the_movie_app.fragments.ActionFilmFragment

class DynamicPagerAdapter(val fm:FragmentManager,val list: List<MovieGenreVO>):FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment {
        return ActionFilmFragment.newInstance(list[position].id)
    }

    override fun getCount(): Int {
       return list.count()
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return list[position].name
    }
}
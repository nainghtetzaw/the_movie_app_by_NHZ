package com.example.the_movie_app.adapters.viewpageradapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.the_movie_app.fragments.ActionFilmFragment

class CategoryViewPagerAdapter(fm : FragmentManager) : FragmentStatePagerAdapter(fm){

    override fun getCount(): Int {
        return 5
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when(position){
            0 -> {
                return "ACTION"
            }
            1 -> {
                return "ADVENTURE"
            }
            2 -> {
                return "CRIMINAL"
            }
            3 -> {
                return "DRAMA"
            }
            4 -> {
                return "COMEDY"
            }
        }
        return null
    }

    override fun getItem(position: Int): Fragment {
        when(position){
            0 -> return ActionFilmFragment.newInstance("a","b")
            else -> return ActionFilmFragment.newInstance("a","b")
        }
    }
}
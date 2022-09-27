package com.aether.moviesmvp20.view

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class TabsFragmentAdapter(fm: FragmentManager, behavior: Int) : FragmentPagerAdapter(fm, behavior) {

    private val listFragment:MutableList<Fragment> = ArrayList()
    private val titleList:MutableList<String> = ArrayList()

    fun addItem(fragment: Fragment, title:String){
        listFragment.add(fragment)
        titleList.add(title)
    }

    override fun getCount(): Int {
        return listFragment.size
    }

    override fun getItem(position: Int): Fragment {
        return listFragment[position]
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return titleList[position]
    }
}

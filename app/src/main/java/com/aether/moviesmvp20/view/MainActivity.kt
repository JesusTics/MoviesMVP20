package com.aether.moviesmvp20.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TableLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.aether.moviesmvp20.R
import com.aether.moviesmvp20.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        inicializar()
    }
    fun inicializar(){
        val adapter = TabsFragmentAdapter(supportFragmentManager, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT)
        adapter.addItem(MovieMainFragment(),"Movies")
        adapter.addItem(FavoriteMovieFragment(),"Favorites")

        val viewPager:ViewPager = binding.viewPager
        viewPager.adapter= adapter

        val tableLayout : TabLayout = binding.tabs
        tableLayout.setupWithViewPager(viewPager)



    }
}
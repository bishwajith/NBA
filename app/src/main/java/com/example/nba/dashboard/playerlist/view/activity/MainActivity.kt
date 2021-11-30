package com.example.nba.dashboard.playerlist.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.nba.dashboard.playerlist.view.adapter.SectionsPagerAdapter
import com.example.nba.dashboard.playerlist.view.fragment.TabInfo
import com.example.nba.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sectionsPagerAdapter = SectionsPagerAdapter(supportFragmentManager, lifecycle)
        val viewPager: ViewPager2 = binding.viewPager
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = binding.tabs
        // disabling swipe
        viewPager.isUserInputEnabled = false
        TabLayoutMediator(tabs, viewPager) { tab, position ->
            tab.text = TabInfo.values()[position].name
        }.attach()
    }
}

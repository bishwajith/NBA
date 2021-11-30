package com.example.nba.dashboard.playerlist.view.adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.nba.dashboard.playerlist.view.fragment.PlaceholderFragment
import com.example.nba.dashboard.playerlist.view.fragment.PlayersFragment
import com.example.nba.dashboard.playerlist.view.fragment.TabInfo

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class SectionsPagerAdapter(fm: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fm, lifecycle) {

    override fun getItemCount(): Int {
        return TabInfo.values().size
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            TabInfo.PLAYERS.ordinal -> PlayersFragment.newInstance(Bundle())
            else -> PlaceholderFragment.newInstance(position + 1)
        }
    }
}

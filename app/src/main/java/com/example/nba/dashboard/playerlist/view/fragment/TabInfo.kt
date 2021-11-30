package com.example.nba.dashboard.playerlist.view.fragment

import androidx.annotation.StringRes
import com.example.nba.R

enum class TabInfo(@StringRes val titleResId: Int) {
    PLAYERS(R.string.tab_players),
    TAB1(R.string.tab_text_2),
    TAB2(R.string.tab_text_3)
}

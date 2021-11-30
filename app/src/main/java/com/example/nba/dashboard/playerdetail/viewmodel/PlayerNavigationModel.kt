package com.example.nba.dashboard.playerdetail.viewmodel

import android.os.Parcelable
import com.example.nba.dashboard.playerlist.repository.remote.responsemodels.Player

@kotlinx.parcelize.Parcelize
data class PlayerNavigationModel(val players: List<Player>, val currentSelectedPlayerPosition: Int) : Parcelable

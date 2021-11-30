package com.example.nba.dashboard.playerlist.viewmodel

import com.example.core.BaseViewEvent
import com.example.nba.dashboard.playerdetail.viewmodel.PlayerNavigationModel

sealed class PlayerViewEvents: BaseViewEvent {
    data class NavigateToPlayerDetail(val playerNavigationModel: PlayerNavigationModel): PlayerViewEvents()
}

package com.example.nba.dashboard.playerlist.viewmodel

import com.example.core.BaseItemState
import com.example.core.BaseViewState
import com.example.nba.dashboard.playerlist.view.adapter.model.PlayerListItemTypes

data class PlayerViewState(val playersList: List<BaseItemState<PlayerListItemTypes>>) : BaseViewState

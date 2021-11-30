package com.example.nba.dashboard.playerlist.viewmodel.itemstates

import com.example.core.BaseItemState
import com.example.nba.dashboard.playerlist.view.adapter.model.PlayerListItemTypes

data class ErrorUIModel(override val viewType: PlayerListItemTypes = PlayerListItemTypes.ITEM_ERROR) : BaseItemState<PlayerListItemTypes>

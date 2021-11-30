package com.example.nba.dashboard.playerlist.viewmodel.itemstates

import com.example.core.BaseItemState
import com.example.nba.dashboard.playerlist.view.adapter.model.PlayerListItemTypes

data class PlayerItemUIModel(
    val name: String,
    val teamName: String,
    val cityName: String,
    val avatarUrl: String,
    val position: Int,
    override val viewType: PlayerListItemTypes = PlayerListItemTypes.ITEM_TYPE_PLAYER
) : BaseItemState<PlayerListItemTypes>

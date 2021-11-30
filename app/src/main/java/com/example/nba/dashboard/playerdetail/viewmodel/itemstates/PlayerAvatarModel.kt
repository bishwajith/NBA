package com.example.nba.dashboard.playerdetail.viewmodel.itemstates

import com.example.core.BaseItemState
import com.example.nba.dashboard.playerdetail.view.adapter.PlayerDetailItemTypes

data class PlayerAvatarModel(
    val avatarUrl: String,
    val name: String,
    val position: Int,
    override val viewType: PlayerDetailItemTypes = PlayerDetailItemTypes.PLAYER_AVATAR_VIEW
) : BaseItemState<PlayerDetailItemTypes>

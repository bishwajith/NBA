package com.example.nba.dashboard.playerdetail.viewmodel

import com.example.core.BaseItemState
import com.example.core.BaseViewState
import com.example.nba.dashboard.playerdetail.view.adapter.PlayerDetailItemTypes
import com.example.nba.dashboard.playerdetail.viewmodel.itemstates.PlayerDetailUIModel

data class PlayerDetailViewState(
    val players: List<BaseItemState<PlayerDetailItemTypes>>,
    val playerDetailUIModel: PlayerDetailUIModel,
    val currentSelectedPosition: Int
) : BaseViewState

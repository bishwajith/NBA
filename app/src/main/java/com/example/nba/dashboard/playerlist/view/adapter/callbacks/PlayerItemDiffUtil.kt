package com.example.nba.dashboard.playerlist.view.adapter.callbacks

import androidx.recyclerview.widget.DiffUtil
import com.example.core.BaseItemState
import com.example.nba.dashboard.playerlist.view.adapter.model.PlayerListItemTypes

class PlayerItemDiffUtil : DiffUtil.ItemCallback<BaseItemState<PlayerListItemTypes>>() {
    override fun areContentsTheSame(oldItem: BaseItemState<PlayerListItemTypes>, newItem: BaseItemState<PlayerListItemTypes>): Boolean {
        return oldItem == newItem
    }

    override fun areItemsTheSame(oldItem: BaseItemState<PlayerListItemTypes>, newItem: BaseItemState<PlayerListItemTypes>): Boolean {
        return oldItem.viewType == newItem.viewType
    }
}

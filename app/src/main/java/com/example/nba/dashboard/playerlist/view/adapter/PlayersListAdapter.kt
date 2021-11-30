package com.example.nba.dashboard.playerlist.view.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.core.BaseItemState
import com.example.core.BaseViewHolder
import com.example.nba.dashboard.playerlist.view.adapter.callbacks.PlayerItemDiffUtil
import com.example.nba.dashboard.playerlist.view.adapter.model.PlayerListItemTypes
import com.example.nba.dashboard.playerlist.viewmodel.PlayersListViewModel

class PlayersListAdapter(private val viewModel: PlayersListViewModel) : ListAdapter<BaseItemState<PlayerListItemTypes>, BaseViewHolder<BaseItemState<PlayerListItemTypes>>>(PlayerItemDiffUtil()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<BaseItemState<PlayerListItemTypes>> {
        return PlayerListItemTypes.values()[viewType].createViewHolder(parent, viewModel)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<BaseItemState<PlayerListItemTypes>>, position: Int) {
        holder.bindView(getItem(position))
    }

    override fun getItemViewType(position: Int): Int {
        return getItem(position).viewType.ordinal
    }
}

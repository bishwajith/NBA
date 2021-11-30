package com.example.nba.dashboard.playerdetail.view.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.core.BaseItemState
import com.example.core.BaseViewHolder
import com.example.nba.dashboard.playerdetail.viewmodel.PlayerDetailViewModel

class PlayerDetailSideAdapter(private val detailViewModel: PlayerDetailViewModel) : ListAdapter<BaseItemState<PlayerDetailItemTypes>, BaseViewHolder<BaseItemState<PlayerDetailItemTypes>>>(object : DiffUtil.ItemCallback<BaseItemState<PlayerDetailItemTypes>>() {
    override fun areItemsTheSame(oldItem: BaseItemState<PlayerDetailItemTypes>, newItem: BaseItemState<PlayerDetailItemTypes>): Boolean {
        return oldItem.viewType == newItem.viewType
    }

    override fun areContentsTheSame(oldItem: BaseItemState<PlayerDetailItemTypes>, newItem: BaseItemState<PlayerDetailItemTypes>): Boolean {
        return oldItem == newItem
    }

}) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<BaseItemState<PlayerDetailItemTypes>> {
        return PlayerDetailItemTypes.values()[viewType].createViewHolder(parent, detailViewModel)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<BaseItemState<PlayerDetailItemTypes>>, position: Int) {
        holder.bindView(getItem(position))
    }
}

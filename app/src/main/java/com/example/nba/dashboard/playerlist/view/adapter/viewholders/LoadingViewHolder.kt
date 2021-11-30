package com.example.nba.dashboard.playerlist.view.adapter.viewholders

import com.example.core.BaseViewHolder
import com.example.nba.dashboard.playerlist.viewmodel.itemstates.LoadingUIModel
import com.example.nba.databinding.ItemLoadingBinding

class LoadingViewHolder(binding: ItemLoadingBinding) : BaseViewHolder<LoadingUIModel>(binding.root) {
    override fun bindView(data: LoadingUIModel) {
        // NO - OP
    }
}

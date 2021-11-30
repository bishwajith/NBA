package com.example.nba.dashboard.playerlist.view.adapter.viewholders

import com.example.core.BaseViewHolder
import com.example.nba.dashboard.playerlist.viewmodel.itemstates.ErrorUIModel
import com.example.nba.databinding.ItemErrorBinding

class ErrorViewHolder(binding: ItemErrorBinding) : BaseViewHolder<ErrorUIModel>(binding.root) {
    override fun bindView(data: ErrorUIModel) {
        // NO - OP
    }
}

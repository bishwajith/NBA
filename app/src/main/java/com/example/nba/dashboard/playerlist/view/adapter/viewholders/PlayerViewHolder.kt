package com.example.nba.dashboard.playerlist.view.adapter.viewholders

import androidx.lifecycle.ViewModel
import com.example.core.BaseViewHolder
import com.example.nba.BR
import com.example.nba.dashboard.playerlist.viewmodel.itemstates.PlayerItemUIModel
import com.example.nba.databinding.ItemPlayerBinding

class PlayerViewHolder(viewModel: ViewModel, private val binding: ItemPlayerBinding) : BaseViewHolder<PlayerItemUIModel>(binding.root) {

    init {
        binding.setVariable(BR.viewmodel, viewModel)
    }

    override fun bindView(data: PlayerItemUIModel) {
        with(binding) {
            setVariable(BR.player, data)
        }
    }
}

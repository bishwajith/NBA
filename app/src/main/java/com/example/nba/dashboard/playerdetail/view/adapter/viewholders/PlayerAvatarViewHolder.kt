package com.example.nba.dashboard.playerdetail.view.adapter.viewholders

import androidx.lifecycle.ViewModel
import com.example.core.BaseViewHolder
import com.example.nba.BR
import com.example.nba.dashboard.playerdetail.viewmodel.itemstates.PlayerAvatarModel
import com.example.nba.databinding.ItemDetailPlayerSmallBinding

class PlayerAvatarViewHolder(
    private val binding: ItemDetailPlayerSmallBinding,
    viewModel: ViewModel
) : BaseViewHolder<PlayerAvatarModel>(binding.root) {

    init {
        binding.setVariable(BR.detailViewModel, viewModel)
    }

    override fun bindView(data: PlayerAvatarModel) {
        with(binding) {
            setVariable(BR.playerAvatar, data)
        }
    }
}

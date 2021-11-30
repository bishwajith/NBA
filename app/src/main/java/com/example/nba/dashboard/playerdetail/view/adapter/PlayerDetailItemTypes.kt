package com.example.nba.dashboard.playerdetail.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import com.example.core.BaseItemState
import com.example.core.BaseViewHolder
import com.example.nba.dashboard.playerdetail.view.adapter.viewholders.PlayerAvatarViewHolder
import com.example.nba.databinding.ItemDetailPlayerSmallBinding

enum class PlayerDetailItemTypes {
    PLAYER_AVATAR_VIEW {
        override fun createViewHolder(parent: ViewGroup, viewModel: ViewModel): BaseViewHolder<BaseItemState<PlayerDetailItemTypes>> {
            return PlayerAvatarViewHolder(
                ItemDetailPlayerSmallBinding.inflate(LayoutInflater.from(parent.context), parent, false),
                viewModel
            ) as BaseViewHolder<BaseItemState<PlayerDetailItemTypes>>
        }
    };

    abstract fun createViewHolder(parent: ViewGroup, viewModel: ViewModel): BaseViewHolder<BaseItemState<PlayerDetailItemTypes>>
}

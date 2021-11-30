package com.example.nba.dashboard.playerlist.view.adapter.model

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import com.example.core.BaseItemState
import com.example.core.BaseViewHolder
import com.example.nba.dashboard.playerlist.view.adapter.viewholders.ErrorViewHolder
import com.example.nba.dashboard.playerlist.view.adapter.viewholders.LoadingViewHolder
import com.example.nba.dashboard.playerlist.view.adapter.viewholders.PlayerViewHolder
import com.example.nba.databinding.ItemErrorBinding
import com.example.nba.databinding.ItemLoadingBinding
import com.example.nba.databinding.ItemPlayerBinding

enum class PlayerListItemTypes {
    ITEM_TYPE_PLAYER {
        override fun createViewHolder(parent: ViewGroup, viewModel: ViewModel): BaseViewHolder<BaseItemState<PlayerListItemTypes>> {
            val binding: ItemPlayerBinding = ItemPlayerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return PlayerViewHolder(viewModel, binding)
                as BaseViewHolder<BaseItemState<PlayerListItemTypes>>
        }

    },
    ITEM_LOADING {
        override fun createViewHolder(parent: ViewGroup, viewModel: ViewModel): BaseViewHolder<BaseItemState<PlayerListItemTypes>> {
            val binding: ItemLoadingBinding = ItemLoadingBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return LoadingViewHolder(binding)
                as BaseViewHolder<BaseItemState<PlayerListItemTypes>>
        }
    },
    ITEM_ERROR {
        override fun createViewHolder(parent: ViewGroup, viewModel: ViewModel): BaseViewHolder<BaseItemState<PlayerListItemTypes>> {
            val binding = ItemErrorBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return ErrorViewHolder(binding)
                as BaseViewHolder<BaseItemState<PlayerListItemTypes>>
        }
    };

    abstract fun createViewHolder(parent: ViewGroup, viewModel: ViewModel): BaseViewHolder<BaseItemState<PlayerListItemTypes>>
}

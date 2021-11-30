package com.example.nba.dashboard.playerlist.usecase

import com.example.nba.dashboard.playerlist.repository.remote.PlayerApiConstants
import com.example.nba.dashboard.playerlist.repository.remote.responsemodels.PlayersResponse
import io.reactivex.rxjava3.core.Single

interface PlayerListUseCase {
    fun fetchPlayers(pageNo: Int = PlayerApiConstants.DEFAULT_PAGE_NO): Single<PlayersResponse>
}

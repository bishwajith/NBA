package com.example.nba.dashboard.playerlist.repository.remote

import com.example.nba.dashboard.playerlist.repository.remote.responsemodels.PlayersResponse
import io.reactivex.rxjava3.core.Single

interface PlayerRemoteRepository {
    fun getPlayers(pageNo: Int): Single<PlayersResponse>
}

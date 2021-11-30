package com.example.nba.dashboard.playerlist.repository.remote

import com.example.core.domain.ApiServiceProvider
import com.example.nba.dashboard.playerlist.repository.remote.responsemodels.PlayersResponse
import io.reactivex.rxjava3.core.Single

class PlayerRemoteRepositoryImpl : PlayerRemoteRepository {
    private val playersService = ApiServiceProvider.retrofit.create(PlayersService::class.java)

    override fun getPlayers(pageNo: Int): Single<PlayersResponse> {
        return playersService.getPlayers(pageNo)
    }
}

package com.example.nba.dashboard.playerlist.usecase

import com.example.nba.dashboard.playerlist.repository.remote.PlayerRemoteRepository
import com.example.nba.dashboard.playerlist.repository.remote.PlayerRemoteRepositoryImpl
import com.example.nba.dashboard.playerlist.repository.remote.responsemodels.PlayersResponse
import io.reactivex.rxjava3.core.Single

class PlayerListUseCaseImpl : PlayerListUseCase {
    private val playerRemoteRepository: PlayerRemoteRepository = PlayerRemoteRepositoryImpl()

    override fun fetchPlayers(pageNo: Int): Single<PlayersResponse> {
        return playerRemoteRepository.getPlayers(pageNo)
    }
}

package com.example.nba.dashboard.playerlist.repository.remote

import com.example.nba.dashboard.playerlist.repository.remote.PlayerApiConstants.PLAYERS_PATH
import com.example.nba.dashboard.playerlist.repository.remote.PlayerApiConstants.QUERY_PAGE
import com.example.nba.dashboard.playerlist.repository.remote.responsemodels.PlayersResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface PlayersService {
    @GET(PLAYERS_PATH)
    fun getPlayers(@Query(QUERY_PAGE) pageNo: Int): Single<PlayersResponse>
}

package com.example.nba.dashboard.playerlist.repository.remote.responsemodels


import com.google.gson.annotations.SerializedName

data class PlayersResponse(
    @SerializedName("data")
    val playersList: List<Player>,
    @SerializedName("meta")
    val meta: Meta
)

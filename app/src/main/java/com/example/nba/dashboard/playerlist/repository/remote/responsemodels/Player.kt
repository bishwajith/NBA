package com.example.nba.dashboard.playerlist.repository.remote.responsemodels


import android.os.Parcelable
import com.example.nba.dashboard.playerlist.repository.remote.PlayerApiConstants
import com.google.gson.annotations.SerializedName

@kotlinx.parcelize.Parcelize
data class Player(
    @SerializedName("first_name")
    val firstName: String,
    @SerializedName("height_feet")
    val heightFeet: String? = null,
    @SerializedName("height_inches")
    val heightInches: String? = null,
    @SerializedName("id")
    val id: Int,
    @SerializedName("last_name")
    val lastName: String,
    @SerializedName("position")
    val position: String,
    @SerializedName("team")
    val team: Team,
    @SerializedName("weight_pounds")
    val weightPounds: String? = null
) : Parcelable

fun Player.avatarUrl(): String {
    return PlayerApiConstants.PLAYERS_AVATAR_URL.format(lastName, firstName)
}

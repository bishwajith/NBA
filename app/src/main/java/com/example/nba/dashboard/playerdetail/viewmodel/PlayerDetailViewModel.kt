package com.example.nba.dashboard.playerdetail.viewmodel

import android.util.Log
import com.example.core.BaseViewModel
import com.example.nba.dashboard.playerdetail.viewmodel.itemstates.PlayerAvatarModel
import com.example.nba.dashboard.playerdetail.viewmodel.itemstates.PlayerDetailUIModel
import com.example.nba.dashboard.playerlist.repository.remote.responsemodels.Player
import com.example.nba.dashboard.playerlist.repository.remote.responsemodels.avatarUrl
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class PlayerDetailViewModel : BaseViewModel<PlayerDetailViewState, PlayerDetailViewEvent>() {
    companion object {
        private const val TAG = "PlayerDetailViewModel"
        private const val SPACE = " "
        private const val CITY_DELIMITER = " | "
    }

    private lateinit var players: List<Player>

    fun init(model: PlayerNavigationModel) {
        buildViewState(model)
    }

    private fun buildViewState(model: PlayerNavigationModel) {
        launchJob {
            Single.fromCallable {
                players = model.players
                val playerAvatarList = model.players.mapIndexed { index, player ->
                    buildPlayerAvatarModel(index, player)
                }
                val playerDetailUIModel = buildPlayerDetailUIModel(model.players[model.currentSelectedPlayerPosition])
                PlayerDetailViewState(playerDetailUIModel = playerDetailUIModel, players = playerAvatarList, currentSelectedPosition = model.currentSelectedPlayerPosition)
            }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    mutableStateLiveData.value = it
                }, {
                    Log.d(TAG, "Error $it")
                })
        }
    }

    fun onSideItemClick(position: Int) {
        Single.fromCallable {
            buildPlayerDetailUIModel(players[position])
        }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                mutableStateLiveData.value = viewStateLiveData.value?.copy(playerDetailUIModel = it, currentSelectedPosition = position)
            }, {
                Log.d(TAG, "Error $it")
            })

    }

    private fun buildPlayerDetailUIModel(player: Player): PlayerDetailUIModel {
        return player.run {
            PlayerDetailUIModel(
                name = firstName.plus(SPACE).plus(lastName),
                teamName = team.name,
                cityName = team.city.plus(CITY_DELIMITER).plus(team.division),
                avatarUrl = avatarUrl(),
            )
        }
    }

    private fun buildPlayerAvatarModel(index: Int, player: Player): PlayerAvatarModel {
        return PlayerAvatarModel(
            avatarUrl = player.avatarUrl(),
            name = player.firstName,
            position = index
        )
    }
}

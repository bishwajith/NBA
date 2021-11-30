package com.example.nba.dashboard.playerlist.viewmodel

import androidx.annotation.VisibleForTesting
import com.example.core.BaseItemState
import com.example.core.BaseViewModel
import com.example.nba.dashboard.playerdetail.viewmodel.PlayerNavigationModel
import com.example.nba.dashboard.playerlist.repository.remote.responsemodels.Player
import com.example.nba.dashboard.playerlist.repository.remote.responsemodels.avatarUrl
import com.example.nba.dashboard.playerlist.usecase.PlayerListUseCase
import com.example.nba.dashboard.playerlist.usecase.PlayerListUseCaseImpl
import com.example.nba.dashboard.playerlist.view.adapter.model.PlayerListItemTypes
import com.example.nba.dashboard.playerlist.viewmodel.itemstates.ErrorUIModel
import com.example.nba.dashboard.playerlist.viewmodel.itemstates.LoadingUIModel
import com.example.nba.dashboard.playerlist.viewmodel.itemstates.PlayerItemUIModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.functions.Consumer
import io.reactivex.rxjava3.schedulers.Schedulers

class PlayersListViewModel : BaseViewModel<PlayerViewState, PlayerViewEvents>() {

    companion object {
        private val playerListUseCase: PlayerListUseCase = PlayerListUseCaseImpl()
        private const val SPACE = " "
        private const val CITY_DELIMITER = " | "
    }

    private var players: List<Player>? = null

    fun init() {
        fetchPlayers()
    }

    private fun fetchPlayers() {
        launchJob {
            playerListUseCase.fetchPlayers()
                .map {
                    players = it.playersList
                    transformPlayerResponse(it.playersList)
                }
                .onErrorReturn {
                    buildErrorState()
                }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe {
                    mutableStateLiveData.value = PlayerViewState(buildLoadingState())
                }
                .subscribe(Consumer {
                    mutableStateLiveData.value = PlayerViewState(it)
                })
        }
    }

    @VisibleForTesting
    fun transformPlayerResponse(playersList: List<Player>): List<BaseItemState<PlayerListItemTypes>> {
        return playersList.mapIndexed { index, player ->
            player.run {
                PlayerItemUIModel(
                    name = firstName.plus(SPACE).plus(lastName),
                    teamName = team.name,
                    cityName = team.city.plus(CITY_DELIMITER).plus(team.division),
                    avatarUrl = avatarUrl(),
                    position = index
                )
            }
        }
    }

    @VisibleForTesting
    fun buildLoadingState(): List<BaseItemState<PlayerListItemTypes>> {
        return listOf(LoadingUIModel())
    }


    @VisibleForTesting
    fun buildErrorState(): List<BaseItemState<PlayerListItemTypes>> {
        return listOf(ErrorUIModel())
    }

    fun onPlayerClick(position: Int) {
        val list = if (position > 0) {
            // to make end index inclusive
            players?.subList(0, position + 1)
        } else {
            players
        } ?: emptyList()
        val playerNavigationModel = PlayerNavigationModel(list, position)
        mutableEventLiveData.value = PlayerViewEvents.NavigateToPlayerDetail(playerNavigationModel)
    }
}

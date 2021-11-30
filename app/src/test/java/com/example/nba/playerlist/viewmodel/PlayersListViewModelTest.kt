package com.example.nba.playerlist.viewmodel

import com.example.core.BaseItemState
import com.example.nba.dashboard.playerlist.repository.remote.responsemodels.Player
import com.example.nba.dashboard.playerlist.repository.remote.responsemodels.Team
import com.example.nba.dashboard.playerlist.repository.remote.responsemodels.avatarUrl
import com.example.nba.dashboard.playerlist.view.adapter.model.PlayerListItemTypes
import com.example.nba.dashboard.playerlist.viewmodel.PlayersListViewModel
import com.example.nba.dashboard.playerlist.viewmodel.itemstates.ErrorUIModel
import com.example.nba.dashboard.playerlist.viewmodel.itemstates.LoadingUIModel
import com.example.nba.dashboard.playerlist.viewmodel.itemstates.PlayerItemUIModel
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class PlayersListViewModelTest {

    private lateinit var viewModel: PlayersListViewModel

    @Before
    fun init() {
        viewModel = PlayersListViewModel()
    }

    @Test
    fun `given a player object, when transformPlayerResponse is called, then validate list of PlayerItemUIModel`() {
        val player = Player(
            firstName = "John",
            lastName = "Doe",
            id = 10,
            team = Team(
                name = "TeamName",
                city = "City",
                division = "Div",
                abbreviation = "", fullName = "", conference = "", id = 1
            ),
            position = "111"
        )
        val mockPlayers: List<Player> = listOf(player)
        val list: List<BaseItemState<PlayerListItemTypes>> = viewModel.transformPlayerResponse(mockPlayers)
        assertEquals(mockPlayers.size, list.size)
        list.forEachIndexed { index, it ->
            assertTrue(it is PlayerItemUIModel)
            val playerItemUIModel = it as PlayerItemUIModel
            assertEquals("John Doe", playerItemUIModel.name)
            assertEquals("TeamName", playerItemUIModel.teamName)
            assertEquals("City | Div", playerItemUIModel.cityName)
            assertEquals(index, playerItemUIModel.position)
            assertEquals(player.avatarUrl(), playerItemUIModel.avatarUrl)
            assertEquals(PlayerListItemTypes.ITEM_TYPE_PLAYER, playerItemUIModel.viewType)
        }
    }

    @Test
    fun `given an error state, then validate error ui model`() {
        val expectedListSize = 1
        val list: List<BaseItemState<PlayerListItemTypes>> = viewModel.buildErrorState()
        assertEquals(expectedListSize, list.size)
        assertTrue(list.first() is ErrorUIModel)
        assertEquals(PlayerListItemTypes.ITEM_ERROR, list.first().viewType)
    }

    @Test
    fun `given an loading state, then validate loading ui model`() {
        val expectedListSize = 1
        val list: List<BaseItemState<PlayerListItemTypes>> = viewModel.buildLoadingState()
        assertEquals(expectedListSize, list.size)
        assertTrue(list.first() is LoadingUIModel)
        assertEquals(PlayerListItemTypes.ITEM_LOADING, list.first().viewType)
    }
}

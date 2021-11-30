package com.example.nba.dashboard.playerlist.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nba.dashboard.playerdetail.view.activity.PlayerDetailActivity
import com.example.nba.dashboard.playerdetail.viewmodel.PlayerNavigationModel
import com.example.nba.dashboard.playerlist.view.adapter.PlayersListAdapter
import com.example.nba.dashboard.playerlist.viewmodel.PlayerViewEvents
import com.example.nba.dashboard.playerlist.viewmodel.PlayersListViewModel
import com.example.nba.databinding.FragmentPlayersBinding

class PlayersFragment : Fragment() {

    companion object {
        private const val TAG = "PlayersFragment"
        fun newInstance(bundle: Bundle?) = PlayersFragment().apply {
            arguments = bundle
        }
    }

    private val viewModel: PlayersListViewModel by lazy {
        ViewModelProvider(this@PlayersFragment)[PlayersListViewModel::class.java]
    }

    private lateinit var binding: FragmentPlayersBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPlayersBinding.inflate(LayoutInflater.from(context), container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        observeViewState()
        observeViewEvent()
        viewModel.init()
    }

    private fun initAdapter() {
        val playerAdapter = PlayersListAdapter(viewModel)
        with(binding.playersRecyclerView) {
            layoutManager = LinearLayoutManager(context)
            adapter = playerAdapter
        }
    }

    private fun observeViewState() {
        viewModel.viewStateLiveData.observe(viewLifecycleOwner) {
            (binding.playersRecyclerView.adapter as PlayersListAdapter).submitList(it.playersList)
        }
    }

    private fun observeViewEvent() {
        viewModel.viewEventLiveData.observe(viewLifecycleOwner) { event ->
            when (event) {
                is PlayerViewEvents.NavigateToPlayerDetail -> navigateToDetail(event.playerNavigationModel)
            }
        }
    }

    private fun navigateToDetail(playerNavigationModel: PlayerNavigationModel) {
        PlayerDetailActivity.initActivity(requireContext(), playerNavigationModel)
    }
}

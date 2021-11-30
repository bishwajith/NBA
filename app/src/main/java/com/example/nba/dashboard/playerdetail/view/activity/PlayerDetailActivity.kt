package com.example.nba.dashboard.playerdetail.view.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nba.BR
import com.example.nba.R
import com.example.nba.dashboard.playerdetail.view.adapter.PlayerDetailSideAdapter
import com.example.nba.dashboard.playerdetail.viewmodel.PlayerDetailViewModel
import com.example.nba.dashboard.playerdetail.viewmodel.PlayerNavigationModel
import com.example.nba.databinding.ActivityPlayerDetailBinding
import kotlin.math.max

class PlayerDetailActivity : AppCompatActivity() {

    companion object {
        private const val KEY_NAVIGATION_MODEL = "NavigationModel"

        fun initActivity(context: Context, playerNavigationModel: PlayerNavigationModel) {
            Intent(context, PlayerDetailActivity::class.java).apply {
                putExtra(KEY_NAVIGATION_MODEL, playerNavigationModel)
                context.startActivity(this)
            }
        }
    }

    private val detailViewModel: PlayerDetailViewModel by lazy {
        ViewModelProvider(this@PlayerDetailActivity)[PlayerDetailViewModel::class.java]
    }

    private var sideItemHeight: Int = 0

    private lateinit var binding: ActivityPlayerDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlayerDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sideItemHeight = resources.getDimension(R.dimen.side_item_width_height).toInt()
        val playerDetailNavModel = intent?.getParcelableExtra<PlayerNavigationModel>(KEY_NAVIGATION_MODEL)
        initAdapter()
        observeViewState()
        playerDetailNavModel?.let {
            detailViewModel.init(it)
        }
    }

    private fun initAdapter() {
        with(binding.playersAvatarRecyclerview) {
            val detailSideAdapter = PlayerDetailSideAdapter(detailViewModel)
            adapter = detailSideAdapter
            layoutManager = object : LinearLayoutManager(context) {
                override fun checkLayoutParams(lp: RecyclerView.LayoutParams?): Boolean {
                    val newHeight = height / detailSideAdapter.currentList.size
                    lp?.height = max(sideItemHeight, newHeight)
                    return true
                }
            }
        }
    }

    private fun observeViewState() {
        detailViewModel.viewStateLiveData.observe(this) { viewState ->
            (binding.playersAvatarRecyclerview.adapter as PlayerDetailSideAdapter).submitList(viewState.players)
            (binding.playersAvatarRecyclerview.scrollToPosition(viewState.currentSelectedPosition))
            binding.setVariable(BR.playerDetailModel, viewState.playerDetailUIModel)
        }
    }
}

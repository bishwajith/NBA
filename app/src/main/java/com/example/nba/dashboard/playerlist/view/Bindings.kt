package com.example.nba.dashboard.playerlist.view

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.nba.R

@BindingAdapter(
    value =
    ["glideSrc",
        "circleCrop"],
    requireAll = false
)
fun ImageView.bindGlideSrc(avatarUrl: String?, isCircleCrop: Boolean = false) {
    if (avatarUrl == null) {
        this.setImageResource(R.drawable.ic_avatar)
        return
    }
    var requestBuilder = Glide.with(context)
        .load(avatarUrl)
        .error(R.drawable.ic_avatar)

    if (isCircleCrop) {
        requestBuilder = requestBuilder.circleCrop()
    }
    requestBuilder
        .placeholder(R.drawable.ic_avatar)
        .centerCrop()
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .into(this)
}

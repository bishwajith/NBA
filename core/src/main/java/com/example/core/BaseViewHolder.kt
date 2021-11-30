package com.example.core

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<T>(binding: View) : RecyclerView.ViewHolder(binding) {
    abstract fun bindView(data: T)
}

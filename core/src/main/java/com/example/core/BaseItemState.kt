package com.example.core

interface BaseItemState<T> {
    val viewType: T

    override fun equals(other: Any?): Boolean

    override fun hashCode(): Int
}

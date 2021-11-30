package com.example.core.domain

import com.example.core.ApiConstants
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object ApiServiceProvider {
    val retrofit: Retrofit by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
        Retrofit.Builder()
            .baseUrl(ApiConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
    }

}

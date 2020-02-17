package com.kotlin.init.mrezapue.formacionja.model

import android.app.Application
import android.content.Context
import com.kotlin.init.mrezapue.formacionja.R

class MovieRpository(context: Context?) {

    private val apiKey =  context?.getString(R.string.key_api_movie)
    private val regionRepository = "US"

    suspend fun getListMoview() =
        MovieServiceManager.service.getlistPopularMoviesAsync(apiKey,regionRepository)

}
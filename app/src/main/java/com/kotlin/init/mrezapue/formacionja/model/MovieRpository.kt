package com.kotlin.init.mrezapue.formacionja.model

import android.app.Application
import com.kotlin.init.mrezapue.formacionja.R

class MovieRpository(application: Application) {

    private val apiKey = application.getString(R.string.key_api_movie)
    private val regionRepository = "US"

    suspend fun getListMoview() =
        MovieServiceManager.service.getlistPopularMoviesAsync(apiKey,regionRepository)

}
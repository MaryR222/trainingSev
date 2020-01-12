package com.kotlin.init.mrezapue.formacionja.model

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {



    @GET("discover/movie?sort_by=popularity.desc")
    suspend fun listPopularMoviesAsync(
        @Query("api_key") apiKey: String,
        @Query("region") region: String
    ): Response<MovieResponse>
}
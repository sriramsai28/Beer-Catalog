package com.sriram.beerlist.data.remote

import retrofit2.http.GET
import retrofit2.http.Query

const val BASE_URL = "https://api.punkapi.com/v2/"

interface API {

    @GET("beers")
    suspend fun getBeers(
        @Query("page") page: Int,
        @Query("per_page") pageCount: Int
    ): List<BeerDto>
}
package com.example.librarytestapplication.model

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

class RetrofitInterface {
    interface CreateWikipediaService{
        @GET("api")
//        suspend fun getWikipediaSearchResult() : Response<dataBody>
        suspend fun getWikipediaSearchResult(@Query("keyword") keyword : String) : Response<dataBody>
    }
}
package com.example.librarytestapplication.model

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

class RetrofitInterface {
    interface CreateWikipediaService{
        @GET("{keyWord}")
        suspend fun getWikipediaSearchResult(@Path("keyWord") key_word : String) : Response<dataResults>
    }
}
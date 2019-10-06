package com.example.librarytestapplication.model

import retrofit2.Retrofit
import retrofit2.converter.simplexml.SimpleXmlConverterFactory
import com.example.librarytestapplication.model.RetrofitInterface.CreateWikipediaService
import retrofit2.Response

class WikipediaRepository {
    val retrofit = Retrofit.Builder()
        .baseUrl("http://wikipedia.simpleapi.net/api?keyword=")
        .addConverterFactory(SimpleXmlConverterFactory.create())
        .build()

    val wikipediaService: CreateWikipediaService = retrofit.create(CreateWikipediaService::class.java)

    suspend fun getWikipediaResultList(keyWord : String) : Response<dataResults> =
            wikipediaService.getWikipediaSearchResult(keyWord)
}
package com.example.librarytestapplication.model

import com.example.librarytestapplication.model.RetrofitInterface.CreateWikipediaService
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.simplexml.SimpleXmlConverterFactory

class WikipediaRepository {
    val retrofit = Retrofit.Builder()
        .baseUrl("http://wikipedia.simpleapi.net/")
        .addConverterFactory(SimpleXmlConverterFactory.create())
        .build()

    val wikipediaService: CreateWikipediaService = retrofit.create(CreateWikipediaService::class.java)

    suspend fun getWikipediaResultList(keyWord: String): Response<dataBody> =
            wikipediaService.getWikipediaSearchResult(keyWord)

    // singletonでRepositoryインスタンスを返すFactory
    companion object Factory {

        val instance: WikipediaRepository
            @Synchronized get() {
                return WikipediaRepository()
            }
    }
}

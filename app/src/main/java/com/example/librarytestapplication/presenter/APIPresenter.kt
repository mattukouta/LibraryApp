package com.example.librarytestapplication.presenter

import android.os.Handler
import android.text.Editable
import android.util.Log
import com.example.librarytestapplication.model.WikipediaList
import com.example.librarytestapplication.model.WikipediaRepository
import com.example.librarytestapplication.model.dataElement
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class APIPresenter(private val view : APIContract.View) : APIContract.Presenter {
    override fun start() {
    }

    override fun editTextCheck(editText : Editable){
        if(editText.isNotEmpty()) {
            val keyword = editText.toString()
            getWikipediaRequest(keyword)
        } else {
            view.showEmptyMessage()
        }
    }

    override fun initWikipediaList() {
        val wikipediaList = WikipediaList.Companion

        wikipediaList.language.clear()
        wikipediaList.id.clear()
        wikipediaList.url.clear()
        wikipediaList.title.clear()
        wikipediaList.body.clear()
        wikipediaList.length.clear()
        wikipediaList.redirect.clear()
        wikipediaList.strict.clear()
        wikipediaList.datetime.clear()
    }

    override fun addWikipediaList(result: dataElement) {
        val wikipediaList = WikipediaList.Companion

        wikipediaList.language.add(result.language)
        wikipediaList.id.add(result.id.toString())
        wikipediaList.url.add(result.url)
        wikipediaList.title.add(result.title)
        wikipediaList.body.add(result.body)
        wikipediaList.length.add(result.length)
        wikipediaList.redirect.add(result.redirect)
        wikipediaList.strict.add(result.strict)
        wikipediaList.datetime.add(result.datetime)
    }

    override fun getWikipediaRequest(keyword : String) {
        val repository = WikipediaRepository.instance

        val handler = Handler()

        GlobalScope.launch {
            val request = repository.getWikipediaResultList(keyword)

            if (request.isSuccessful) {
                val results = request.body()?.result

               initWikipediaList()

                if (results != null) {
                    for (result in results) {
                        addWikipediaList(result)
                    }

                    // Handlerを使用してメイン(UI)スレッドに処理を依頼する
                    handler.post {
                        view.showAdapter()
                    }

                } else {
                    Log.d("check", "request is null")
                }
            } else {
                Log.d("check", "request is fail")
            }
        }
    }
}
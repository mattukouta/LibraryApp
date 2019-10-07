package com.example.librarytestapplication.view.api

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.librarytestapplication.R
import com.example.librarytestapplication.model.WikipediaList
import com.example.librarytestapplication.model.WikipediaRepository
import com.example.librarytestapplication.util.KeyStringUntils
import kotlinx.android.synthetic.main.activity_api.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import android.os.Handler


class APIActivity : AppCompatActivity() {

    private val repository = WikipediaRepository.instance

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_api)

        val position = intent.extras?.getInt(KeyStringUntils().MAIN_LIST_KEY, 100)

        searchButton.setOnClickListener {
            if(keywordText.text.isNotEmpty()) {
                val keyword = keywordText.text.toString()
                getWikipediaData(keyword)

                showAdapter()
            }
        }

    }

    fun getWikipediaData(keyword: String) {

        val handler = Handler()

        GlobalScope.launch {
            val request = repository.getWikipediaResultList(keyword)

            if (request.isSuccessful) {
                val results = request.body()?.result
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

                if (results != null) {
                    for (result in results) {
                        wikipediaList.language.add(result.language)
                        wikipediaList.id.add(result.id.toString())
                        wikipediaList.url.add(result.url)
                        wikipediaList.title.add(result.title)
                        wikipediaList.body.add(result.body)
                        wikipediaList.length.add(result.length)
                        wikipediaList.redirect.add(result.redirect)
                        wikipediaList.strict.add(result.strict)
                        wikipediaList.datetime.add(result.datetime)
                        Log.d("check", result.title)
                    }

                    // Handlerを使用してメイン(UI)スレッドに処理を依頼する
                    handler.post(Runnable {
                        showAdapter()
                    })

                } else {
                    Log.d("check", "request is null")
                }
            } else {
                Log.d("check", "request is fail")
            }
        }

//        GlobalScope.launch {
//            try {
//                val request = repository.getWikipediaResultList("hoge")
//                Log.d("check", "request")
//
//                if (request.isSuccessful) {
//                    val results = request.body()?.results
//                    val wikipediaList = WikipediaList.Companion
//                    if (results != null) {
//                        for (result in results) {
//                            wikipediaList.body.add(result.result.language)
//                            wikipediaList.body.add(result.result.id.toString())
//                            wikipediaList.body.add(result.result.url)
//                            wikipediaList.body.add(result.result.title)
//                            wikipediaList.body.add(result.result.title)
//                            wikipediaList.body.add(result.result.length)
//                            wikipediaList.body.add(result.result.redirect)
//                            wikipediaList.body.add(result.result.strict)
//                            wikipediaList.body.add(result.result.datetime)
//                            Log.d("check", result.result.title)
//                        }
//                        showAdapter()
//                    }
//                }
//            } catch (e: Exception) {
//                e.stackTrace
//            }
//        }
    }

    fun showAdapter() {
        val adapter = WikipediaListAdapter(this)

        WikipediaListRecyclerView.adapter = adapter
        WikipediaListRecyclerView.layoutManager = LinearLayoutManager(this)
    }
}

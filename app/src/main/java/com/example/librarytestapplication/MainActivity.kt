package com.example.librarytestapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val titles = listOf("APIテスト", "coroutine" )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val titleList = mutableListOf<MainCell>()
        for(title in titles) {
            titleList.add(MainCell(title))
        }
//        repeat((0 .. 100).count()) {titleList.add(MainCell("hoge", "http://www.hakodate-sweets.com/pgm/img/main02-20130830040341.jpg"))}

        TitleListRecyclerView.adapter = MainListAdapter(this, titleList)
        TitleListRecyclerView.layoutManager = LinearLayoutManager(this)

        TitleListRecyclerView.also {

        }
    }
}

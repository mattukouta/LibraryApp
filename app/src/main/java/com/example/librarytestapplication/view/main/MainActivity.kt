package com.example.librarytestapplication.view.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.librarytestapplication.R
import com.example.librarytestapplication.model.MainCell
import com.example.librarytestapplication.util.MainListDataUtils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val titleList = mutableListOf<MainCell>()
        for(title in MainListDataUtils().titles) {
            titleList.add(MainCell(title))
        }
//        repeat((0 .. 100).count()) {titleList.add(MainCell("hoge", "http://www.hakodate-sweets.com/pgm/img/main02-20130830040341.jpg"))}

        TitleListRecyclerView.adapter = MainListAdapter(this, titleList)
        TitleListRecyclerView.layoutManager = LinearLayoutManager(this)

    }
}

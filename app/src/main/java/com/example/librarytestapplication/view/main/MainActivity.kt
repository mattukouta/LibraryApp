package com.example.librarytestapplication.view.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
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
        for (title in MainListDataUtils().titles) {
            titleList.add(MainCell(title))
        }
//        repeat((0 .. 100).count()) {titleList.add(MainCell("hoge", "http://www.hakodate-sweets.com/pgm/img/main02-20130830040341.jpg"))}
        val adapter = MainListAdapter(this, titleList)

        TitleListRecyclerView.adapter = adapter
        TitleListRecyclerView.layoutManager = LinearLayoutManager(this)

        /**
         * recyclerViewのクリックイベントをActiviryで実装する場合
         */
//        adapter.setOnItemClickListener(View.OnClickListener { view ->
//            Toast.makeText(this, "hoge", Toast.LENGTH_SHORT).show()
//        })
    }
}

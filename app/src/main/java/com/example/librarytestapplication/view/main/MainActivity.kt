package com.example.librarytestapplication.view.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.librarytestapplication.R
import com.example.librarytestapplication.model.MainCell
import com.example.librarytestapplication.util.MainListDataUtils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        repeat((0 .. 100).count()) {titleList.add(MainCell("hoge", "http://www.hakodate-sweets.com/pgm/img/main02-20130830040341.jpg"))}
        showTitleList()

        /**
         * recyclerViewのクリックイベントをActiviryで実装する場合
         */
//        adapter.setOnItemClickListener(View.OnClickListener { view ->
//            Toast.makeText(this, "hoge", Toast.LENGTH_SHORT).show()
//        })
    }

    fun createTitleList(): MutableList<MainCell> {
        val titleList = mutableListOf<MainCell>()
        for (title in MainListDataUtils().titles) {
            titleList.add(MainCell(title))
        }

        return titleList
    }

    fun showTitleList() {

        val titleList = createTitleList()

        val adapter = MainListAdapter(this, titleList)
        val separateLine = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)

        TitleListRecyclerView.adapter = adapter
        TitleListRecyclerView.layoutManager = LinearLayoutManager(this)
        TitleListRecyclerView.addItemDecoration(separateLine)
    }
}

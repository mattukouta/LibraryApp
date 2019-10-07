package com.example.librarytestapplication.view.api

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.librarytestapplication.R
import kotlinx.android.synthetic.main.activity_api.*
import android.widget.Toast
import com.example.librarytestapplication.presenter.APIContract
import com.example.librarytestapplication.presenter.APIPresenter


class APIActivity : AppCompatActivity(), APIContract.View {

    override lateinit var presenter : APIContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_api)

        presenter = APIPresenter(this)

//        val position = intent.extras?.getInt(KeyStringUntils().MAIN_LIST_KEY, 100)

        searchButton.setOnClickListener {
            presenter.editTextCheck(keywordText.text)
        }

    }

    override fun showAdapter() {
        val adapter = WikipediaListAdapter(this)

        WikipediaListRecyclerView.adapter = adapter
        WikipediaListRecyclerView.layoutManager = LinearLayoutManager(this)
    }

    override fun showEmptyMessage() {
        Toast.makeText(this, "キーワードを入力してください", Toast.LENGTH_SHORT).show()
    }
}

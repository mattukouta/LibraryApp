package com.example.librarytestapplication.view.api

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.librarytestapplication.R
import com.example.librarytestapplication.presenter.APIContract
import com.example.librarytestapplication.presenter.APIPresenter
import kotlinx.android.synthetic.main.activity_api.*
import kotlinx.android.synthetic.main.progress_layout.*

class APIActivity : AppCompatActivity(), APIContract.View {

    override lateinit var presenter: APIContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_api)

        presenter = APIPresenter(this)
        showProgressBar()

//        val position = intent.extras?.getInt(KeyStringUntils().MAIN_LIST_KEY, 100)

        searchButton.setOnClickListener {
            presenter.editTextCheck(keywordText.text)
        }
    }

    override fun showAdapter() {
        val adapter = WikipediaListAdapter(this)
        val separateLine = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)

        WikipediaListRecyclerView.adapter = adapter
        WikipediaListRecyclerView.layoutManager = LinearLayoutManager(this)
        WikipediaListRecyclerView.addItemDecoration(separateLine)
    }

    override fun showEmptyMessage() {
        Toast.makeText(this, "キーワードを入力してください", Toast.LENGTH_SHORT).show()
    }

    override fun showProgressBar() {
        progressLayout.visibility = View.VISIBLE
    }

    override fun hideProgressBar() {
        progressLayout.visibility = View.INVISIBLE
    }
}

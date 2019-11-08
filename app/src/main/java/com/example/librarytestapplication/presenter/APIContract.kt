package com.example.librarytestapplication.presenter

import android.text.Editable
import com.example.librarytestapplication.BasePresenter
import com.example.librarytestapplication.BaseView
import com.example.librarytestapplication.model.dataElement

interface APIContract {
    interface View : BaseView<Presenter> {

        fun showAdapter()
        fun showEmptyMessage()
        fun showProgressBar()
        fun hideProgressBar()
    }
    interface Presenter : BasePresenter {

        fun editTextCheck(editText: Editable)
        fun getWikipediaRequest(keyword: String)
        fun initWikipediaList()
        fun addWikipediaList(result: dataElement)
    }
}

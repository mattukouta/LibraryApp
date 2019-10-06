package com.example.librarytestapplication.view.api

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.librarytestapplication.R
import com.example.librarytestapplication.util.KeyStringUntils

class APIActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_api)

        val position = intent.extras?.getInt(KeyStringUntils().MAIN_LIST_KEY, 100)



    }
}

package com.example.librarytestapplication.model

import org.simpleframework.xml.Element

data class dataBody (
    @Element
    val language : String,
    @Element
    val id : Int,
    @Element
    val url : String,
    @Element
    var title : String,
    @Element
    var body : String,
    @Element
    var length : String,
    @Element
    var redirect : String,
    @Element
    var strict : String,
    @Element
    var datetime : String
)
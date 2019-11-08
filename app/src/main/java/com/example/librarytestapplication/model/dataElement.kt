package com.example.librarytestapplication.model

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "result")
data class dataElement(

    @field:Element(name = "language", required = false)
    @param:Element(name = "language", required = false)
    val language: String,

    @field:Element(name = "id", required = false)
    @param:Element(name = "id", required = false)
    val id: Int,

    @field:Element(name = "url", required = false)
    @param:Element(name = "url", required = false)
    val url: String,

    @field:Element(name = "title", required = false)
    @param:Element(name = "title", required = false)
    val title: String,

    @field:Element(name = "body", required = false)
    @param:Element(name = "body", required = false)
    val body: String,

    @field:Element(name = "length", required = false)
    @param:Element(name = "length", required = false)
    val length: String,

    @field:Element(name = "redirect", required = false)
    @param:Element(name = "redirect", required = false)
    val redirect: String,

    @field:Element(name = "strict", required = false)
    @param:Element(name = "strict", required = false)
    val strict: String,

    @field:Element(name = "datetime", required = false)
    @param:Element(name = "datetime", required = false)
    val datetime: String
)

package com.example.librarytestapplication.model

import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

@Root(name = "results")
data class dataBody(
    @field:ElementList(name = "result", inline = true, required = false)
    @param:ElementList(name = "result", inline = true, required = false)
    var result: List<dataElement>
//    @ElementList(name = "result", inline = true, required = false)
//    val result : ArrayList<dataBody>
//    val result: List<dataElement>
)

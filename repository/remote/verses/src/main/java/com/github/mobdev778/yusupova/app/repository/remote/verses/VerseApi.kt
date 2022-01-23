package com.github.mobdev778.yusupova.app.repository.remote.verses

import com.squareup.moshi.Json

internal class VerseApi {

    @Json(name = "id")
    var id: Int = 0

    @Json(name = "name")
    lateinit var title: String

    @Json(name = "lines")
    lateinit var lines: List<String>

}
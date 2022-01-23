package com.github.mobdev778.yusupova.app.repository.remote.verses

import com.squareup.moshi.Json

internal class BookApi {

    @Json(name = "id")
    var id: Int = 0

    @Json(name = "name")
    lateinit var name: String

    @Json(name = "verses")
    lateinit var verses: List<VerseApi>

}
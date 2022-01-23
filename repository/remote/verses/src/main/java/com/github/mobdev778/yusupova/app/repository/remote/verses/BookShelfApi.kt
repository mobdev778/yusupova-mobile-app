package com.github.mobdev778.yusupova.app.repository.remote.verses

import com.squareup.moshi.Json

internal class BookShelfApi {

    @Json(name = "version")
    var version: Int = 0

    @Json(name = "books")
    lateinit var books: List<BookApi>

}
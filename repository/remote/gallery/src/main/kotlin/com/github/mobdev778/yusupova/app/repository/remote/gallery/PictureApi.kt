package com.github.mobdev778.yusupova.app.repository.remote.gallery

import com.squareup.moshi.Json

internal class PictureApi {

    @Json(name = "name")
    lateinit var name: String

    @Json(name = "path")
    lateinit var path: String

}
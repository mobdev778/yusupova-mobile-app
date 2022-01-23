package com.github.mobdev778.yusupova.app.repository.remote.verses

import retrofit2.http.GET
import retrofit2.http.Path

internal interface VersesServiceApi {

    @GET("verses_{apiLocale}.json")
    suspend fun verses(@Path("apiLocale") apiLocale: String): BookShelfApi

}
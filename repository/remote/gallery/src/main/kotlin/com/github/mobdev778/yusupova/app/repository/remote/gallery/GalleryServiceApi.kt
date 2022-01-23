package com.github.mobdev778.yusupova.app.repository.remote.gallery

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Streaming
import retrofit2.http.Url

internal interface GalleryServiceApi {

    @GET("gallery_{apiLocale}.json")
    suspend fun pictures(@Path("apiLocale") apiLocale: String): List<PictureApi>

    @Streaming
    @GET
    fun picture(@Url fileUrl: String): Call<ResponseBody>

}
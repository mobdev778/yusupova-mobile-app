package com.github.mobdev778.yusupova.app.repository.remote.gallery

import com.github.mobdev778.yusupova.app.core.data.repository.gallery.IGalleryRemoteRepository
import com.github.mobdev778.yusupova.app.core.domain.entities.app.AppLocale
import com.github.mobdev778.yusupova.app.core.domain.entities.gallery.Picture
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.ResponseBody
import retrofit2.Callback
import retrofit2.Call
import retrofit2.Response
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

internal class GalleryRemoteRepository(
    val appLocale: AppLocale,
    val galleryServiceApi: GalleryServiceApi
): IGalleryRemoteRepository {

    override suspend fun getPictures(): List<Picture> {
        val apiLocale = appLocale.name.lowercase()
        val pictures = galleryServiceApi.pictures(apiLocale)
        return pictures
            .map { pictureApi -> pictureApi.toPicture() }
            .toList()
    }

    @Suppress("BlockingMethodInNonBlockingContext")
    override suspend fun getPicture(path: String): File {
        val stream = getPictureStream(path)
        stream.use {
            return withContext(Dispatchers.IO) {
                val file = File.createTempFile("gallery", "jpg")
                FileOutputStream(file).use {
                    val buffer = ByteArray(4096)
                    while (true) {
                        val bytesRead = stream.read(buffer)
                        if (bytesRead == -1) {
                            break
                        }
                        it.write(buffer, 0, bytesRead)
                    }
                }
                file
            }
        }
    }

    private suspend fun getPictureStream(path: String): InputStream {
        return suspendCoroutine { continuation ->
            galleryServiceApi.picture(path).enqueue(object: Callback<ResponseBody> {
                override fun onResponse(
                    call: Call<ResponseBody>,
                    response: Response<ResponseBody>
                ) {
                    val body = response.body()
                    if (body != null) {
                        continuation.resume(body.byteStream())
                    } else {
                        continuation.resumeWithException(NullPointerException())
                    }
                }

                override fun onFailure(call: Call<ResponseBody>, error: Throwable) {
                    continuation.resumeWithException(error)
                }
            })
        }
    }

}
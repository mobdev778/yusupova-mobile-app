package com.github.mobdev778.yusupova.app.core.data.repository.gallery

import com.github.mobdev778.yusupova.app.core.domain.entities.gallery.Picture
import java.io.File

interface IGalleryRemoteRepository {

    suspend fun getPictures(): List<Picture>

    suspend fun getPicture(path: String): File

}
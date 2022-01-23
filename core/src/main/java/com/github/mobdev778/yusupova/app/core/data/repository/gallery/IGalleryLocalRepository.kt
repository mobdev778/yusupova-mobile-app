package com.github.mobdev778.yusupova.app.core.data.repository.gallery

import com.github.mobdev778.yusupova.app.core.domain.entities.gallery.Picture
import java.io.File

interface IGalleryLocalRepository {

    fun getPictures(): List<Picture>

    fun savePictures(pictures: List<Picture>)

    fun getPicture(path: String): File

    fun savePicture(path: String, file: File)

}
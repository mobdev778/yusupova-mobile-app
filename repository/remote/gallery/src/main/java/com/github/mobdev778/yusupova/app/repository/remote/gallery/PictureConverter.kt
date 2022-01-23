package com.github.mobdev778.yusupova.app.repository.remote.gallery

import com.github.mobdev778.yusupova.app.core.domain.entities.gallery.Picture

internal fun PictureApi.toPicture(): Picture {
    return Picture(name, path)
}
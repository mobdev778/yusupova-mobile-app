package com.github.mobdev778.yusupova.app.splash

import android.net.Uri

sealed class VideoUriState {

    object Loading: VideoUriState()
    data class Complete(val uri: Uri): VideoUriState()

}
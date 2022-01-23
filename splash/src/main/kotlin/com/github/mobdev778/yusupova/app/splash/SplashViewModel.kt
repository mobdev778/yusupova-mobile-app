package com.github.mobdev778.yusupova.app.splash

import android.content.ContentResolver
import android.content.Context
import android.content.res.Configuration
import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch

class SplashViewModel: ViewModel() {

    private var videoUriJob: Job? = null

    private val _videoUri : MutableStateFlow<VideoUriState> =
        MutableStateFlow(VideoUriState.Loading)

    val videoUri: Flow<VideoUriState> = _videoUri

    fun updateVideoUri(context: Context) {
        if (videoUriJob?.isActive == true) {
            return
        }
        videoUriJob = viewModelScope.launch(Dispatchers.Main) {
            _videoUri.value = VideoUriState.Loading
            val nightMode = context.resources.configuration.uiMode and
                    Configuration.UI_MODE_NIGHT_MASK
            val videoId = when (nightMode) {
                Configuration.UI_MODE_NIGHT_YES -> R.raw.splash_1080_dark
                else -> R.raw.splash_1080
            }
            val uri = Uri.Builder()
                .scheme(ContentResolver.SCHEME_ANDROID_RESOURCE)
                .authority(context.packageName)
                .appendPath("$videoId")
                .build()
            _videoUri.value = VideoUriState.Complete(uri)
        }
    }

}
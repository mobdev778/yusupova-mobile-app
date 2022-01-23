package com.github.mobdev778.yusupova.app.splash

import android.content.ContentResolver
import android.content.Context
import android.content.res.Configuration
import android.net.Uri
import android.util.AttributeSet
import android.widget.VideoView
import androidx.lifecycle.*

class SplashVideoView(context: Context, attrs: AttributeSet): VideoView(
    context, attrs
), LifecycleEventObserver {

    private var lastVideoUri: Uri? = null

    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        when (event) {
            Lifecycle.Event.ON_START -> {
                val videoUri = getVideoUri()
                if (videoUri != lastVideoUri) {
                    lastVideoUri = videoUri
                    setVideoURI(videoUri)
                }
                start()
            }
            Lifecycle.Event.ON_STOP -> {
                super.stopPlayback()
            }
            else -> { /* do nothing */ }
        }
    }

    private fun getVideoUri(): Uri {
        val nightMode = context.resources.configuration.uiMode and
                Configuration.UI_MODE_NIGHT_MASK
        val videoId = when (nightMode) {
            Configuration.UI_MODE_NIGHT_YES -> R.raw.splash_1080_dark
            else -> R.raw.splash_1080
        }
        return Uri.Builder()
            .scheme(ContentResolver.SCHEME_ANDROID_RESOURCE)
            .authority(context.packageName)
            .appendPath("$videoId")
            .build()
    }

}
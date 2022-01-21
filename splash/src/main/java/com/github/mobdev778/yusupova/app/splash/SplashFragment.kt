package com.github.mobdev778.yusupova.app.splash

import android.content.ContentResolver
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.VideoView
import androidx.fragment.app.Fragment
import com.github.mobdev778.yusupova.app.splash.databinding.FragmentSplashBinding

class SplashFragment: Fragment(R.layout.fragment_splash) {

    private lateinit var videoView: VideoView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentSplashBinding.inflate(inflater)
        videoView = binding.videoView
        val uri = Uri.Builder()
            .scheme(ContentResolver.SCHEME_ANDROID_RESOURCE)
            .authority(requireContext().packageName)
            .appendPath("${R.raw.splash_1080}")
            .build()
        videoView.setVideoURI(uri)
        // исправляем баг с черным фоном во время подгрузки видео
        videoView.setZOrderOnTop(true)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        videoView.start()
    }

    override fun onStop() {
        videoView.stopPlayback()
        super.onStop()
    }

}
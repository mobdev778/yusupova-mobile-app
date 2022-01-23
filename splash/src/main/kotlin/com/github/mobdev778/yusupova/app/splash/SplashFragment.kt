package com.github.mobdev778.yusupova.app.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.github.mobdev778.yusupova.app.splash.databinding.FragmentSplashBinding

class SplashFragment: Fragment(R.layout.fragment_splash) {

    private lateinit var videoView: SplashVideoView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentSplashBinding.inflate(inflater)
        videoView = binding.videoView
        videoView.setZOrderOnTop(true)
        viewLifecycleOwner.lifecycle.addObserver(videoView)
        return binding.root
    }

}
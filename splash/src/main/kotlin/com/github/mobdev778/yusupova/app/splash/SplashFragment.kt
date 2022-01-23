package com.github.mobdev778.yusupova.app.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.VideoView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.github.mobdev778.yusupova.app.splash.databinding.FragmentSplashBinding
import kotlinx.coroutines.launch

class SplashFragment: Fragment(R.layout.fragment_splash) {

    private lateinit var videoView: VideoView

    private val viewModel: SplashViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentSplashBinding.inflate(inflater)
        videoView = binding.videoView
        videoView.setZOrderOnTop(true)

        // исправляем баг с черным фоном во время подгрузки видео

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launch {
            viewModel.videoUri.collect {
                when (it) {
                    is VideoUriState.Complete -> {
                        videoView.setVideoURI(it.uri)
                        videoView.start()
                    }
                    else -> { /* */ }
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        viewModel.updateVideoUri(requireContext())
    }

    override fun onStop() {
        videoView.stopPlayback()
        super.onStop()
    }

}
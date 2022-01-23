package com.github.mobdev778.yusupova.app.repository.remote.gallery

import com.github.mobdev778.yusupova.app.core.di.AppScope
import com.github.mobdev778.yusupova.app.repository.remote.gallery.di.RemoteGalleryModule
import com.github.mobdev778.yusupova.app.repository.remote.retrofit.di.RetrofitModule
import dagger.Component

@AppScope
@Component(modules = [
    RemoteTestModule::class, RetrofitModule::class, RemoteGalleryModule::class
])
internal interface RemoteTestComponent {

    fun inject(test: GalleryRemoteRepositoryTest)

    @Component.Builder
    interface Builder {

        fun build(): RemoteTestComponent

    }

}
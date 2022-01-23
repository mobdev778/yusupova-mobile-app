package com.github.mobdev778.yusupova.app.repository.remote.gallery.di

import com.github.mobdev778.yusupova.app.core.data.repository.app.IAppConfigRepository
import com.github.mobdev778.yusupova.app.core.data.repository.gallery.IGalleryRemoteRepository
import com.github.mobdev778.yusupova.app.repository.remote.gallery.GalleryRemoteRepository
import com.github.mobdev778.yusupova.app.repository.remote.gallery.GalleryServiceApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.create

@Module
class RemoteGalleryModule {

    @Provides
    internal fun providesGalleryServiceApi(
        appConfigRepository: IAppConfigRepository
    ): GalleryServiceApi {
        val serverUrl = appConfigRepository.serverUrl
        val retrofit = Retrofit.Builder()
            .baseUrl(serverUrl)
            .build()
        return retrofit.create()
    }

    @Provides
    internal fun providesRemoteVersesRepository(
        appConfigRepository: IAppConfigRepository,
        galleryServiceApi: GalleryServiceApi
    ): IGalleryRemoteRepository {
        val appLocale = appConfigRepository.appLocale
        return GalleryRemoteRepository(appLocale, galleryServiceApi)
    }

}
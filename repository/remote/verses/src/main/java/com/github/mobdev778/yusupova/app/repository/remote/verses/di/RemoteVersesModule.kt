package com.github.mobdev778.yusupova.app.repository.remote.verses.di

import com.github.mobdev778.yusupova.app.core.data.repository.app.IAppConfigRepository
import com.github.mobdev778.yusupova.app.core.data.repository.verses.IVerseRemoteRepository
import com.github.mobdev778.yusupova.app.core.di.AppScope
import com.github.mobdev778.yusupova.app.repository.remote.verses.VerseRemoteRepository
import com.github.mobdev778.yusupova.app.repository.remote.verses.VersesServiceApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.create

@Module
class RemoteVersesModule {

    @AppScope
    @Provides
    internal fun providesVersesServiceApi(
        appConfigRepository: IAppConfigRepository
    ): VersesServiceApi {
        val serverUrl = appConfigRepository.serverUrl
        val retrofit = Retrofit.Builder()
            .baseUrl(serverUrl)
            .build()
        return retrofit.create()
    }

    @Provides
    internal fun providesRemoteVersesRepository(
        appConfigRepository: IAppConfigRepository,
        versesServiceApi: VersesServiceApi
    ): IVerseRemoteRepository {
        val appLocale = appConfigRepository.appLocale
        return VerseRemoteRepository(appLocale, versesServiceApi)
    }

}
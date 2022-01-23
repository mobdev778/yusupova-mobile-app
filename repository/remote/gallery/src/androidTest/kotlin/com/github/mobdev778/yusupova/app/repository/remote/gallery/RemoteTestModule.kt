package com.github.mobdev778.yusupova.app.repository.remote.gallery

import com.github.mobdev778.yusupova.app.core.data.repository.app.IAppConfigRepository
import com.github.mobdev778.yusupova.app.core.domain.entities.app.AppLocale
import dagger.Module
import dagger.Provides

@Module
class RemoteTestModule {

    @Provides
    fun providesAppConfigRepository(): IAppConfigRepository {
        return object: IAppConfigRepository {
            override val appLocale = AppLocale.RU
            override val serverUrl = "https://raw.githubusercontent.com/mobdev778/yusupova-server/master/"
        }
    }

}
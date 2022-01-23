package com.github.mobdev778.yusupova.app.di

import android.content.Context
import com.github.mobdev778.yusupova.app.core.data.repository.app.IAppConfigRepository
import com.github.mobdev778.yusupova.app.core.di.AppScope
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @AppScope
    @Provides
    fun providesAppConfigRepository(context: Context): IAppConfigRepository {
        return AppConfigRepository(context)
    }

}
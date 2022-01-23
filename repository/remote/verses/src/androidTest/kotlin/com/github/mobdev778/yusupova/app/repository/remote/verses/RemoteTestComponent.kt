package com.github.mobdev778.yusupova.app.repository.remote.verses

import com.github.mobdev778.yusupova.app.core.di.AppScope
import com.github.mobdev778.yusupova.app.repository.remote.retrofit.di.RetrofitModule
import com.github.mobdev778.yusupova.app.repository.remote.verses.di.RemoteVersesModule
import dagger.Component

@AppScope
@Component(modules = [
    RemoteTestModule::class, RetrofitModule::class, RemoteVersesModule::class
])
internal interface RemoteTestComponent {

    fun inject(test: VersesRemoteRepositoryTest)

    @Component.Builder
    interface Builder {

        fun build(): RemoteTestComponent

    }

}
package com.github.mobdev778.yusupova.app.di

import android.app.Application
import com.github.mobdev778.yusupova.app.core.di.AppScope
import dagger.BindsInstance
import dagger.Component

@AppScope
@Component(modules = [AppModule::class])
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent

    }

}
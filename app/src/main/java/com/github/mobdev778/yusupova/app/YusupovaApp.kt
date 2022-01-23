package com.github.mobdev778.yusupova.app

import android.app.Application
import com.github.mobdev778.yusupova.app.di.AppComponent
import com.github.mobdev778.yusupova.app.di.DaggerAppComponent

class YusupovaApp: Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .application(this)
            .build()
    }

}
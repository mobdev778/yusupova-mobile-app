package com.github.mobdev778.yusupova.app.di

import android.content.Context
import android.os.Build
import com.github.mobdev778.yusupova.app.core.data.repository.app.IAppConfigRepository
import com.github.mobdev778.yusupova.app.core.domain.entities.app.AppLocale

class AppConfigRepository(val context: Context): IAppConfigRepository {

    override val appLocale: AppLocale by lazy {
        val locale = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
            context.resources.configuration.locales[0]
        } else {
            context.resources.configuration.locale
        }
        when (locale.country.lowercase()) {
            "ru" -> AppLocale.RU
            else -> AppLocale.EN
        }
    }

    override val serverUrl: String
        get() = "https://github.com/mobdev778/yusupova-server"

}
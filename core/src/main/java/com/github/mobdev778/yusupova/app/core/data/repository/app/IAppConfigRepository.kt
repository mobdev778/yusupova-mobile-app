package com.github.mobdev778.yusupova.app.core.data.repository.app

import com.github.mobdev778.yusupova.app.core.domain.entities.app.AppLocale

interface IAppConfigRepository {

    val appLocale: AppLocale
    val serverUrl: String

}
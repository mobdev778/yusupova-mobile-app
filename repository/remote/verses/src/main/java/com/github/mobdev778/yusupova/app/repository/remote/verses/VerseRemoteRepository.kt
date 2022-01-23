package com.github.mobdev778.yusupova.app.repository.remote.verses

import com.github.mobdev778.yusupova.app.core.data.repository.verses.IVerseRemoteRepository
import com.github.mobdev778.yusupova.app.core.domain.entities.app.AppLocale
import com.github.mobdev778.yusupova.app.core.domain.entities.verses.BookShelf

internal class VerseRemoteRepository(
    val appLocale: AppLocale, val versesServiceApi: VersesServiceApi
): IVerseRemoteRepository {

    override suspend fun getBookShelf(): BookShelf {
        val apiLocale = appLocale.name.lowercase()
        val bookShelfApi = versesServiceApi.verses(apiLocale)
        return bookShelfApi.toBookShelf()
    }

}
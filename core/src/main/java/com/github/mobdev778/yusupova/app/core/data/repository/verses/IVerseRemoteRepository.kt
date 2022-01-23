package com.github.mobdev778.yusupova.app.core.data.repository.verses

import com.github.mobdev778.yusupova.app.core.domain.entities.verses.BookShelf

interface IVerseRemoteRepository {

    suspend fun getBookShelf(): BookShelf

}
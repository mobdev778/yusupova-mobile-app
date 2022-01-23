package com.github.mobdev778.yusupova.app.repository.remote.verses

import com.github.mobdev778.yusupova.app.core.domain.entities.verses.Book
import com.github.mobdev778.yusupova.app.core.domain.entities.verses.BookShelf
import com.github.mobdev778.yusupova.app.core.domain.entities.verses.Verse

internal fun BookShelfApi.toBookShelf(): BookShelf {
    val books = books
        .map { bookApi -> bookApi.toBook() }
        .toList()
    return BookShelf(version, books)
}

internal fun BookApi.toBook(): Book {
    val verses = verses
        .map { verseApi -> verseApi.toVerse() }
        .toList()
    return Book(id, name, verses)
}

internal fun VerseApi.toVerse(): Verse {
    return Verse(id, title, lines)
}
